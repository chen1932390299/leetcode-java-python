from multiprocessing import Process,Pool
import time,os
import random

# todo 非阻塞式，执行完就不管了，直到自己全部跑完返回call_back
def task(thing):
    print(f" start do {thing} finish{time.asctime()},pid {os.getpid()}" )
    time.sleep(random.random())
    # print(f" finsh do {thing} finish{time.asctime()}")
    return f" finsh do {thing} finish{time.asctime()}"

def call_backs(msg):
    const=[]
    const.append(msg)
    # print(const)
    return const


if __name__ == '__main__':
    p=Pool(3)
    things = ["eat", "music", "run", "tv"]
    for t  in  things:
        p.apply_async(task,args=(t,),callback=call_backs)

    p.close()  # ValueError: Pool is still running
    p.join()