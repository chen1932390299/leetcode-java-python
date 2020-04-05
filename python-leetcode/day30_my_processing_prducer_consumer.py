import threading
import random, time
import queue

q_init = queue.Queue(maxsize=5)
import logging

logging.basicConfig(level=logging.INFO,
                    format='%(asctime)s  - %(levelname)s -->%(funcName)s  at line %(lineno)d: \n %(message)s')
log = logging.getLogger()
def color_str(tip, color):
    # todo define three color: red,green,blue,gray.
    if color == "red":
        return "\033[31m%s\033[0m" % tip
    elif color == "green":
        return "\033[32m%s\033[0m" % tip

    elif color == "blue":
        return "\033[34m%s\033[0m" % tip

    elif color == "gray":
        return "\033[35m%s\033[0m"%tip

def jobs(item):
    t = random.randint(1, 5)
    time.sleep(t)
    status = random.randint(0, 1)
    if status == 0:
        return ("success", item)
    else:
        return ("failed", item)


def do_work(item):
    msg="do something %s,time start %s" % (item, time.asctime())
    logging.info(color_str(msg,"gray"))
    a = jobs(item)
    return a


def worker(q):
    while True:
        # if queue get None by thread and stop that  thread called by break
        item = q.get()
        if item is None:
            break
        st = do_work(item)
        if st[0] in ["success", "failed"]:

            q_init.task_done()
            msg2="%s task finished status is %s<<< %d" % (st[1], st[0],q.qsize())
            logging.info(color_str(msg2,"blue"))


if __name__ == '__main__':
    threads = []
    thread_num = 5
    for i in range(thread_num):
        t = threading.Thread(target=worker, args=(q_init,))
        t.start()
        threads.append(t)
    for item in range(1, 11):
        q_init.put(item)
    # block until all tasks are done
    q_init.join()
    # stop workers
    for i in range(thread_num):
        q_init.put(None)
    for t in threads:
        t.join()