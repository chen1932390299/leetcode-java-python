import pandas as pd
import numpy as np
# a=["id1","id2","id3"] # len =row
# row=3
# col=2
# b=np.random.normal(0, 1, (3,2))
# print(np.around(b,decimals=5,out=None))
# df1=pd.DataFrame(a)
# df2=pd.DataFrame(b)
# print(df2.values)
# print(pd.concat([df1,df2],axis=1))
# todo read chunksize
# df=pd.read_csv("./breast_b.csv",chunksize=10000,iterator=True)
# for ch in df:
#     print(ch.shape)

y_list=np.random.choice(2,10)
print(pd.DataFrame(y_list).values)

