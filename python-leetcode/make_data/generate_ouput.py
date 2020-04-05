import pandas as pd
import numpy as np

__author__ = 'Chenquan'
# todo before you run generate_output.py,please run shamsg_unique.py to gen id col to csv first for read.
""">>>>10wx1000columns cost 143.43s <<<<< 10wx10columns cost 2.02s"""
# 特征列
col = 10

# generate samples rows numbers,must be the same with id_sha256.csv id rows
totals_row = 100000

# 每次yield分批的写入save_data output数量样本eg:batch_size = 10000
batch_size = 20000

# data_output path for guest or host  data_set
target_path = "./sha_b.csv"

# id_csv path
id_csv_path = "./id_sha256.csv"  # todo id col support numeric and sha256 object type

# with label,生成数据是否带有label
label_switch = True
# data_set id column dtype,$id_csv_path id type is numeric set dtype=np.int64,else dtype=np.object
numeric = False

if batch_size > totals_row:
    raise ValueError(f"batch_size number can't more than samples")


def yield_id():
    data_set = pd.read_csv(id_csv_path, chunksize=batch_size, iterator=True, header=None)
    for it in data_set:
        a = list(map(lambda x: x[0], it.values.tolist()))
        yield a


def concat(with_label):
    ids = yield_id()
    for id_list in ids:  # todo len(id_list)=batch_size
        if numeric:
            id_type = np.int64
        else:
            id_type = None
        df_id = pd.DataFrame(id_list, columns=["id"], dtype=id_type)
        value_a = np.around(np.random.normal(0, 1, (batch_size, col)), decimals=5, out=None)
        df_feature = pd.DataFrame(value_a, columns=[f"x{i}" for i in range(col)])
        if with_label:
            df_y = pd.DataFrame(np.random.choice(2, batch_size), dtype=np.int64, columns=["y"])
            one_iter_data = pd.concat([df_id, df_y, df_feature], axis=1, ignore_index=False)
        else:
            one_iter_data = pd.concat([df_id, df_feature], axis=1, ignore_index=False)
        # print(one_iter_data)
        yield one_iter_data


def save_data(path, with_label):
    """ if with_label true then generate $target_path with label y column """
    one_batch = concat(with_label)
    for index, df_dt in enumerate(one_batch):
        if index == 0:
            print(df_dt.dtypes, "\n")
            print(f"header of csv:\n{df_dt.columns.values.tolist()}")
            df_dt.to_csv(path, index=False)
        else:
            df_dt.to_csv(path, index=False, mode="a", header=None)


if __name__ == '__main__':
    import time

    start = time.time()
    idsha256 = pd.read_csv(id_csv_path, header=None)
    id_sha256_rows = idsha256.shape[0]
    if totals_row == id_sha256_rows:
        pass
    else:
        raise ValueError(
            f"Sample total rows is {totals_row} must be the same with id_sha256.csv id rows size:{id_sha256_rows}")
    save_data(target_path, with_label=label_switch)
    print(time.time() - start)
