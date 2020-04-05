# coding=utf-8
from sklearn.datasets import make_classification
import numpy as np
import pandas as pd
import random
def gen_unique(start,end,N):
    # print("start:%s end:%s N:%s"%(start,end,N))
    random.seed(20)
    ids=random.sample(range(start,end),N)
    # ids=np.arange(start,end+1)
    print("id length is %s "%len(ids))
    print("min id is %s,max id is %s"%(min(ids),max(ids)))
    return ids
def getnarrys(seed,samples,features,used_features:int,unused_features:int,repetaed=0,classes=2,clusters_class=2):
    X, y = make_classification(n_samples=samples,  # 样本个数
                               n_features=features,  # 特征个数
                               n_informative=used_features,  # 有效特征个数
                               n_redundant=unused_features,  # 冗余特征个数（有效特征的随机组合）
                               n_repeated=repetaed,  # 重复特征个数（有效特征和冗余特征的随机组合）
                               n_classes=classes,  # 样本类别
                               n_clusters_per_class=clusters_class,  # 簇的个数
                               random_state=seed,
                               scale=0.1)


    return X,y

def create_guest(start,end,sklearn_config):
    samples=sklearn_config["n_samples"]#50000
    features=sklearn_config["n_features"]
    used_features=sklearn_config["n_informative"]
    unused_features=sklearn_config["n_redundant"]
    seed=sklearn_config["random_state"]
    classes=sklearn_config["n_classes"]
    if samples<=50000:
        datas=getnarrys(0,samples,features,used_features,unused_features)
    else:
        datas = getnarrys(0, 10000, features, used_features, unused_features)
    narrays=datas[0]
    y=datas[1]
    if samples<=50000 and samples>0:
        ids=gen_unique(start,end,samples)
    else:
        ids=gen_unique(start,end,10000)
    dfid=pd.DataFrame(np.array(ids),columns=["id"],dtype=np.int64)
    dfid["y"]=y.tolist()
    df_y=pd.DataFrame(dfid,columns=["id","y"],dtype=np.int64)
    df=pd.DataFrame(narrays,columns=["x%s"%k for k in range(features)])
    dfs=pd.concat((df_y,df),axis=1,ignore_index=False)

    dfs.to_csv("./%srowsX%scols_guest.csv"%(samples,features), index=False)

def son_guest(start,end,sklearn_config):
    samples=sklearn_config["n_samples"]#50000
    features=sklearn_config["n_features"]
    used_features=sklearn_config["n_informative"]
    unused_features=sklearn_config["n_redundant"]
    seed=sklearn_config["random_state"]
    classes=sklearn_config["n_classes"]
    if samples<=50000:
        datas=getnarrys(1,samples,features,used_features,unused_features)
    else:
        # gen 50000 data one for iter
        datas = getnarrys(1, 10000, features, used_features, unused_features)
    #datas=getnarrys(seed=1,features=1000,used_features=800,unused_features=200)
    narrays=datas[0]
    y=datas[1]
    # if samples <= 50000 samples,but this will not used son that samples <=50000
    ids=gen_unique(start,end,10000)
    dfid=pd.DataFrame(np.array(ids),columns=["id"],dtype=np.int64)
    dfid["y"]=y.tolist()
    df_y=pd.DataFrame(dfid,columns=["id","y"],dtype=np.int64)
    df=pd.DataFrame(narrays,columns=["x%s"%k for k in range(features)])
    dfs=pd.concat((df_y,df),axis=1,ignore_index=False)
    dfs.to_csv("./%srowsX%scols_guest.csv"%(samples,features), mode="a",index=False,header=None)
    print("finish write all data to ./%srowsX%scols_guest.csv "%(samples,features))


# def check_read(path):
#
#     size=50000
#     i = 1
#
#     for ch in pd.read_csv(path, chunksize=size, iterator=True):
#         print("=============this is iter {} chunksize {},shape is {} rows X {} cols =============".format(i,size,ch.shape[0],ch.shape[1]))
#         if i==1:
#             print(ch.dtypes[:3])
#             print("shape is %sx%s"%(ch.shape[0],ch.shape[1]))
#             # print("get head(3) of samples DataFrame:\n %s"%ch.head(3))
#         i=i+1
#         print("shape is %sx%s" % (ch.shape[0], ch.shape[1]))


def generate_data_guest(sklearn_config):
    samples=sklearn_config["n_samples"]
    cols=sklearn_config["n_features"]
    step=10000
    if 0<samples<=50000:
        rangers = [[k, k + step] for k in list(range(1, samples, step))]
        print("guest binning is "%rangers)
        for index, ranger in enumerate(rangers):
            start, end = ranger[0], ranger[1]
            create_guest(start,end,sklearn_config)
            print("finish write all data to ./%srowsX%scols_host.csv  " % (samples, cols))
        # check_read("./%srowsX%scols_guest.csv" % (samples, cols))
    else:
        rangers=[[k,k+step]  for k in list(range(1,samples,step))]
        print("guest binning is %s" % rangers)
        for  index,ranger in enumerate(rangers):
             start,end=ranger[0],ranger[1]
             if index==0:
                 create_guest(start,end,sklearn_config)
             else:
                 son_guest(start,end,sklearn_config)
        # check_read("./%srowsX%scols_guest.csv"%(samples,cols))


def create_host(start,end,sklearn_config):
    samples=sklearn_config["n_samples"]#50000
    features=sklearn_config["n_features"]
    used_features=sklearn_config["n_informative"]
    unused_features=sklearn_config["n_redundant"]
    seed=sklearn_config["random_state"]
    classes=sklearn_config["n_classes"]
    if samples<=50000:
        datas=getnarrys(0,samples,features,used_features,unused_features)
    else:
        datas = getnarrys(0, 10000, features, used_features, unused_features)
    narrays=datas[0]
    if samples<=50000:
        ids=gen_unique(start,end,samples)
    else:
        ids=gen_unique(start,end,10000)
    dfid=pd.DataFrame(np.array(ids),columns=["id"],dtype=np.int64)
    df=pd.DataFrame(narrays,columns=["x%s"%k for k in range(features)])
    dfs=pd.concat((dfid,df),axis=1,ignore_index=False)
    dfs.to_csv("./%srowsX%scols_host.csv"%(samples,features), index=False)

def son_host(start,end,sklearn_config):
    samples=sklearn_config["n_samples"]
    features=sklearn_config["n_features"]
    used_features=sklearn_config["n_informative"]
    unused_features=sklearn_config["n_redundant"]
    seed=sklearn_config["random_state"]
    classes=sklearn_config["n_classes"]
    if samples<=50000:
       datas=getnarrys(1,samples,features,used_features,unused_features)
    else:
        datas = getnarrys(1, 10000, features, used_features, unused_features)

    narrays=datas[0]
    # if samples <= 50000 samples,but this will not need
    ids=gen_unique(start,end,10000)
    dfid=pd.DataFrame(np.array(ids),columns=["id"],dtype=np.int64)
    df=pd.DataFrame(narrays,columns=["x%s"%k for k in range(features)])
    dfs=pd.concat((dfid,df),axis=1,ignore_index=False)
    dfs.to_csv("./%srowsX%scols_host.csv"%(samples,features), mode="a",index=False,header=None)
    print("finish write %s data to ./%srowsX%scols_host.csv  "%(10000,samples,features))


def generate_data_host(sklearn_config):
    samples=sklearn_config["n_samples"]
    step=10000
    cols=sklearn_config["n_features"]
    bin=samples/step
    if samples<=50000:

        rangers = [[k, k + step] for k in list(range(1, samples, step))]
        print("bining number is %s"%rangers)
        for index, ranger in enumerate(rangers):
            start, end = ranger[0], ranger[1]
            create_host(start,end,sklearn_config)
            print("finish write %s data to ./%srowsX%scols_host.csv  " % (step,samples, cols))
        # check_read("./%srowsX%scols_host.csv"%(samples, cols))

    else:
        rangers=[[k,k+step]  for k in list(range(1,samples,step))]
        print("bining number is %s" % rangers)
        print("flapper binning ids long %s"%len(rangers))
        for  index,ranger in enumerate(rangers):
             start,end=ranger[0],ranger[1]

             if index==0:
                 create_host(start,end,sklearn_config)
             else:
                 son_host(start,end,sklearn_config)

        # check_read("./%srowsX%scols_host.csv"%(samples,cols))


if __name__ == '__main__':
    sklearn_config1={"n_samples":100,"n_features":25,
            "n_informative":25,"n_redundant":0 ,"random_state":0,"n_classes":2}
    sklearn_config2={"n_samples":100,"n_features":15,
            "n_informative":15,"n_redundant":0 ,"random_state":0,"n_classes":2}
    import time
    st=time.perf_counter()
    # check_read(r"D:\Idetools\AutoFate\reports\500000rowsX1000cols_guest.csv")
    generate_data_host(sklearn_config2)
    generate_data_guest(sklearn_config1)
    print("elapsedTime is "+"%.2f"%(time.perf_counter()/60-st/60)+"min")





