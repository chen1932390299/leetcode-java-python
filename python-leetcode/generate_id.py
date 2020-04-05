import csv
import uuid
from hashlib import sha256
import numpy as np
import argparse
import random,string


def gen_demo(rows:int, each_iter:int, features,mode_encrypt:int):
    """yield one batch_size data by each_iter size in case memory leak """
    capacity = []
    counter = 0
    for i in range(rows):
        temp = []
        uid = str(uuid.uuid1()).replace("-", "")
        if mode_encrypt:
            encrypt = sha256(uid.encode("utf-8")).hexdigest()
        else:
            encrypt=uid+str(''.join(random.sample(string.ascii_letters+string.digits,10)))
        if not features:
            temp.append(encrypt)
        else:
            feature_value = np.around(np.random.normal(0, 1, features), decimals=5, out=None).tolist()
            one_data = [encrypt] + feature_value

            temp.extend(one_data)
        capacity.append(temp)
        counter += 1
        if counter % each_iter == 0:
            print(f" has gen {counter} data")
            pass

    yield capacity


def foo():
    """ example: python  generate_id.py -r 100000 -b 10000 -e 1"""
    parse = argparse.ArgumentParser()
    parse.add_argument("-e","--encrypt",type=int,required=True,help="encrypt 0 mean false,1 mean true ")
    parse.add_argument("-r","--row",required=True,type=int,help="rows of samples")
    parse.add_argument("-f","--features",required=False,type=int,help="number of cols generate features,if -f generate,else false")
    parse.add_argument("-b","--batch_size",required=True,type=int,help="number of each time yield sample batch_size ")
    parse.add_argument("-header","--header",required=False,type=bool,help="if generate header or not true mean yes, false no ")
    parse.add_argument("-n","--name",required=False,type=str,help="the name of save output_data csv")
    args = parse.parse_args()
    if args.features:
        features=args.features
    else:
        features=0
    row = args.row
    each_iter =args.batch_size

    if args.name:
        name=args.name
        print("args name is %s"%name)
    else:
        name="id_sha2562"
    if args.header and features:
        header = ["id"] + [f"x{i}" for i in range(features)]
    else:
        header=None  # TODO if you want keep id_csv with id header, you  can setting header=["id"]
    encrypt_method=args.encrypt
    data=gen_demo(row, each_iter, features, encrypt_method)
    with open("./%s.csv"%name, "w", newline="")as f:
        wr = csv.writer(f)
        if header:
            wr.writerow(header)
        for dt in data:
            wr.writerows(dt)


if __name__ == '__main__':
    print("tip:\n",foo.__doc__)
    foo()


