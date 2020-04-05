# coding=utf-8
# 1.多并发跑五个任务或者算法跑同时交集
#
# 2.max_iter 100 ,跑50棵和100棵树
#
# 3.带特征1000x10w或者50wx1000,
# 4.eps调小，长时间会不会挂
# 5.关注in-mermory
# 6.用多少个partition:
# 1,24 追加3或者6个partition 怕不跑得过
#
import pandas as pd
import numpy as np
import uuid
from hashlib import sha256

# batch_size of each time write rows to id_sha256.csv
batch_size = 200000
# total_samples
total_samples = 100000000
# path_id csv
path_id_csv = "./id_sha256.csv"
# gen numeric,if numeric gen int64 to id_sha256.csv,False gen sha256  object of pandas.
numeric = False
# set header "id"
no_header = True


def foo(band):
    for index, v in enumerate(band):
        a, b = v[0], v[1]
        t = [k for k in range(a, b)]
        yield t


def value_sha(a, b):
    t = []
    if numeric:
        for k in range(a, b + 1):
            t.append(k)
    else:
        for i in range(a, b + 1):
            uid = str(uuid.uuid1()).replace("-", "")
            id_value = sha256(uid.encode("utf-8")).hexdigest()  # todo each time is same uid string,so need sha diff it
            t.append(id_value)
        # print(f"{index+1}次 length of sha_list is {len(t)},range is [{a},{b}]")
    return t


def gen_id(batch_size, samples):
    rangers = [[k, k + batch_size] for k in list(range(0, samples, batch_size))]
    generator = foo(rangers)  # <class.generator>
    for index, value in enumerate(generator):
        a, b = value[0], value[-1]
        v = value_sha(a, b)
        if numeric:
            df = pd.DataFrame(np.array(v), columns=["id"], dtype=np.int64)  # todo  set dtype=np.int64
        else:
            df = pd.DataFrame(np.array(v), columns=["id"])  # todo  set dtype=np.str
        if index == 0:
            print(df.dtypes)
            df = pd.DataFrame(np.array(v), columns=["id"])
            if no_header:
                df.to_csv(path_id_csv, index=False, header=None)
            else:
                df.to_csv(path_id_csv, index=False)
        else:
            df.to_csv(path_id_csv, index=False, header=None, mode="a")
        print(
            f"finish {index + 1}x{batch_size} row time write,value index range is [{value[0]},{value[-1]}],length of sha256msg is {len(value)}")


def check_set():
    df = pd.read_csv(path_id_csv)
    array = df.values.tolist()
    mp = list(map(lambda x: x[0], array))
    print(f"set {path_id_csv} sha256 id columns去重后行数：", len(list(set(mp))))


if __name__ == '__main__':
    import time

    start = time.time()
    gen_id(batch_size, total_samples)
    cost=time.time() - start
    print(f"<<<<<<<<<<finish gen {total_samples} rows sha256 id to {path_id_csv},cost {cost}<<<<<<<<<")
    # check_set()
