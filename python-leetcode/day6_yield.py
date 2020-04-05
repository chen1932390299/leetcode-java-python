from collections.abc import Iterable


def foo():
    print("start....")
    i=0
    while True:
        result = yield i
        i=i+1
        print(f"result is:  {result}")



def G():
    i = 0
    while True:
        m = yield i
        print("m = ", m)
        i += 1
        if i > 100: break

    # try:
    #     generator = foo(3)
    #     print(next(generator)) # TODO 每次next()干了一件什么事呢，简单地说就是yield回一个结果，
    #     # 然后wait,而且下一次next()调用，会接着上一次的yield ,往下走，所以你看到第二次的next,获取到的print的result为None,
    #     print("terminate and wait....")
    #     print(next(generator))
    # except StopIteration as e:
    #     print("skip stop iteration")


if __name__ == '__main__':
    generator=foo()
    msg="可迭代" if isinstance(generator,Iterable) else "不可迭代"
    print(msg)
