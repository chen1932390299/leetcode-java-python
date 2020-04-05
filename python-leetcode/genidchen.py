import  pandas as pd
import numpy as np
# a=range(100000)
# df=pd.DataFrame(np.array(a),dtype=np.int64,columns=["id"])
# print(df.dtypes)
#
# df.to_csv("./ids_1sw.csv",header=None,index=False,)


def  reverse_str(a):
    """
    :param les: a,b,c
    :return:
    """

    length=len(a)
    i,j=0,length-1
    for y in range(length):
        min = a[i]
        temp=min
        a[j]=temp
        i += 1
        j -=1
        if i<j:
            continue
        else:
            break
    print(a)


a=[1,2].reverse()

if __name__ == '__main__':
    reverse_str([1,2,3,4])

