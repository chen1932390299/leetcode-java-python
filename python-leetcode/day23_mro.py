
class Base:

    def foo(self):
        print("---base---->>foo")


class P1(Base):
    # def foo(self):
    #     print("---p1.foo")
    def bar(self):
        print("---->p2.bar")

class P2(Base):
    def  foo(self):
        print("---->p2.bar")

class C1(P1,P2):

    pass
class C2(P1,P2):
    # todo 重写p1.bar
    def bar(self):
        print("----->c2.bar")


class D(C1,C2):
    pass

if __name__ == '__main__':
    d=D()
    print(D.__mro__) #todo python3 经典类和新式类均使用广度优先层次遍历从左到右，再从下往上，也叫广度优先
    d.foo()
    d.bar()
    #todo <class '__main__.D'>, <class '__main__.C1'>, <class '__main__.C2'>,
    # <class '__main__.P1'>, <class '__main__.P2'>, <class '__main__.Base'>, <class 'object'>)

# todo  python2 使用经典类深度优先，新式类广度优先，深度优先一条路走到根，再回来去分叉
#Python类分为两种，一种叫经典类，一种叫新式类。都支持多继承，但继承顺序不同。
#
# 新式类：从object继承来的类。（如:class A(object)），采用广度优先搜索的方式继承（即先水平搜索，再向上搜索）。
#
# 经典类：不从object继承来的类。（如：class A()），采用深度优先搜索的方式继承（即先深入继承树的左侧，再返回，再找右侧）。
#
# Python2.x中类的是有经典类和新式类两种。Python3.x中都是新式类。


class X(object):


    pass


class Y(object):


    pass


class A(X, Y):


    pass


class B(X, Y):
    """
    TODO IF (Y,X),TypeError: Cannot create a consistent method resolution,order (MRO) for bases X, Y
    违背了单调性原则
    """

    pass


class C(A, B):


    pass

print(B.__mro__)
print(A.mro())
print(X.mro())
print(C.mro())
#
# (<class '__main__.B'>, <class '__main__.X'>, <class '__main__.Y'>, <class 'object'>)
# [<class '__main__.A'>, <class '__main__.X'>, <class ' __main__.Y'>, <class 'object'>]
# [<class '__main__.X'>, <class 'object'>]
# [<class '__main__.C'>, <class '__main__.A'>, <class '__main__.B'>, <class '__main__.X'>,
# <class '__main__.Y'>, <class 'object'>]