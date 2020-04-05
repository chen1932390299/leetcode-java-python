import threading

lock = threading.Lock()

class MyThread(threading.Thread):
    def __init__(self, func, args=(), **kwargs):
        super(self.__class__, self).__init__()
        self.func = func
        self.args = args
        print(f"self.args is {args},kwargs is{kwargs}")
        self.kwargs = kwargs

    def run(self):
        lock.acquire()
        self.res =self.func(*self.args, **self.kwargs)
        lock.release()

    def get_result(self):
        try:
            return self.res
        except:
            return None

def test(*args,**kwargs):
    import time
    time.sleep(1)
    print (args,kwargs)


if __name__ =="__main__":
    l = []
    for i in range(5):
        m = MyThread(test,(2,3),d="00")
        #m = MyThread(test, *(4, 5, 6), **{"d": 99999})
        l.append(m)
    for m in l:
        m.start()
    for m in l:
        m.join()