from multiprocessing import Process, Pool
import os
import time
import random
"""阻塞模式,一个执行完了，才可以下一个执行"""
def task(thing):
    print(f" start do {thing} finish{time.asctime()},pid {os.getpid()}" )
    time.sleep(random.random())
    print(f" finsh do {thing} finish{time.asctime()}" )


if __name__ == '__main__':
    things=["eat","music","run","tv"]
    p=Pool(3)
    for t in things:
        p.apply(task,args=(t,))
    p.close()
    p.join()
    print("exit....")