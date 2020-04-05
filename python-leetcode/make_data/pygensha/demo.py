# clery :  https://www.iteye.com/blog/student-lp-2093397
# demo thread queue : https://www.bbsmax.com/A/gAJGVG6gzZ/
# pandas pandas-profiling生成html:  https://www.zhihu.com/question/24590883
from multiprocessing import Process, JoinableQueue
import time

"""
此时的问题是主进程永远不会结束，原因是：生产者p在生产完后就结束了，但是消费者c在取空了q之后，则一直处于死循环中且卡在q.get()这一步。我们的思路是发送结束信号，而有另外一种队列提供了这种机制。

JoinableQueue([maxsize]) ，这就像是一个Queue对象，但队列允许项目的使用者通知生成者项目已经被成功处理。通知进程是使用共享的信号和条件变量来实现的
"""
def producer(q):
    for i in range(3):
        res = '包子%s' % i
        time.sleep(1)
        print('生产者生产%s' % res)
        q.put(res)
    q.join()  # 接收到task_done的信号后，等待消费者把自己放入队列中的所有的数据都取走，生产者才结束


def consumer(q):
    while True:
        time.sleep(2)
        res = q.get()
        print('消费者吃了%s' % res)
        q.task_done()  # 发送信号给q.join()，说明已经从队列中取走一个数据并处理完毕了


if __name__ == '__main__':
    # 容器
    q = JoinableQueue()

    # 生产者们
    p1 = Process(target=producer, args=(q,))
    p2 = Process(target=producer, args=(q,))

    # 消费者们
    c1 = Process(target=consumer, args=(q,))
    c2 = Process(target=consumer, args=(q,))
    c1.daemon = True
    c2.daemon = True

    p1.start()
    c1.start()
    p2.start()
    c2.start()

    p1.join()
    p2.join()

    print('zhu')