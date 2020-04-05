# a,b,*c=(2,4,[5,7],8)
# print(a,b,c,end="")
# j=(1,2,3)
# print(type(j))
from collections.abc import Iterable


def run(*args):
    # todo *args作用就是把传入位置的单个参数打包成一个元组，在内部通过*来解包为单个的参数
    """如果位置参数传入列表或者元组，直接整体存入tuple: ((1, 2),)"""
    print("接受外部传入的位置参数a,b,c打包后并存储在元组,值为：", args)
    print("对*args位置参数解包为单个数字：", *args)


# todo 案例2
def demo(a=()):
    # todo a 默认是一个元组，而且内部使用了*解包操作，意味着a必须是可迭代对象
    print("接收到原始参数保留原始类型list：", a)
    print("对接收参数进行解包成单个参数", *a)  # after * must be an iterable,int不可迭代，也就是a必须是可迭代的


def test(a):
    print(*a)  # todo TypeError: print() argument after * must be an iterable, not int


if __name__ == '__main__':
    run(1, 2)
    print(isinstance(2, Iterable))
    demo((1,))
    print(type((1)))  # <class 'int'>
    print(type((1,)))  # <class 'tuple'>
    test((1))  # 传入必须是一个可迭代的对象在*后的参数
