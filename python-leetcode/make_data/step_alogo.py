import pandas as pd
import numpy as np
step=10000
samples=100000
col=1000
rangers = [[k, k + step] for k in list(range(1, samples, step))]

for index,v in enumerate(rangers):
    a,b=v[0],v[1]
    print(a, b)
    if index ==0:
        # todo this first write with header
        id_list=range(a,b)
        ch=pd.DataFrame(np.array(id_list),columns=["id"])
        array=np.around(np.random.normal(0, 1, (step, col)),decimals=5,out=None)
        df_values = pd.DataFrame(array,columns = [f"x{i}" for i in range(col)])
        df = pd.concat([ch, df_values], axis=1, ignore_index=False)
        df.to_csv("./test_b.csv", index=False)
    else:
        # todo this +1 wr header set None
        id_list=range(a,b)
        ch=pd.DataFrame(np.array(id_list))
        df_values = pd.DataFrame(np.random.normal(0, 1, (step, col)))
        df = pd.concat([ch, df_values], axis=1, ignore_index=False)
        # columns = ["id"] + [f"x{i}" for i in range(col)]
        df.to_csv("./test_b.csv", index=False, mode="a",header=None)
