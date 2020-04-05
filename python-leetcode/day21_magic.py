
# todo ：魔法函数与普通函数区别，就是魔法函数会自动执行调用，而普通需要对象去手动调用
class Dog:
    """__del__ 在引用计数为0时触发垃圾回收"""

    def __init__(self):
        self.name="tom"

    def __call__(self, *args, **kwargs):
        print("----->call------>")
    def __str__(self):
        """need return str type ,else TypeError: __str__ returned non-string (type NoneType)"""
        return "---->__str__: my name is "+self.name+" age is 1---->"
    def __del__(self):
        """__del__ 在引用计数为0时触发垃圾回收"""
        print("----->refcount become 0 ,strart interpreter  del -------")

if __name__ == '__main__':
    p=Dog()
    p1=p
    p2=p
    p()
    print(p)
    print(f"内存地址p.id: {id(p)} ,内存地址p1.id: {id(p1)},内存地址p2.id: {id(p2)}")
    p2.name="jerry"
    print("p.name,p1.name,p2.name--->",p.name,p1.name,p2.name)
    print(f"p2.id {id(p2)}")
    import sys
    print(f"object refcount is 对象p的内存引用计数器数为{sys.getrefcount(p)}") # getrefcount自己引用p一次
    del p1,p2
    del p
    # print(f"refcount is 对象p的内存引用计数器数为{sys.getrefcount(p)}")
    n=1
    n2=n
    print(f"n2 is :{n2},i am for last part code to test gc")