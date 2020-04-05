#
# class A:
#
#     def foo(self):
#         print("---->A.foo")
#
# class B(A):
#
#     def foo(self):
#         print("B.foo----->")
#         A().foo()
#
# class C(A):
#
#     def foo(self):
#         print("C.foo----->")
#         A().foo()
#
#
# class D(B,C):
#     def foo(self):
#         print("D.foo---->")
#         B.foo(self)
#         C.foo(self)



class A:

    def foo(self):
        print("---->A.foo")

class B(A):

    def foo(self):
        print("B.foo----->")
        super().foo()

class C(A):

    def foo(self):
        print("C.foo----->")
        super().foo()


class D(B,C):
    def foo(self):
        print("D.foo---->")
        super().foo()
if __name__ == '__main__':
    d=D()
    d.foo()
# todo  D.foo---->
#       B.foo----->
#       ---->A.foo
#       C.foo----->
#       ---->A.foo


# todo 使用super后：
#  D.foo---->
#  B.foo----->
#  C.foo----->
#  ---->A.foo
