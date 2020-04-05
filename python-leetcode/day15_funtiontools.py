from functools import reduce
import operator
"""
# python3 cmp 函数删除比较使用operator
a=1
b=2
print(operator.lt(a,b))  # True a<b
print(operator.eq(a,b)) # False a==b
print(operator.gt(a,b))  # a>b
print(operator.ge(a,b)) # a>=b
print(operator.le(a,b)) # a<=b
print(operator.ne(a,b)) # a!=b
# todo str  not change variable type
str1="aa"
str2="aa"
print(str1 == str2)  # True
print(str1 is  str2) # True
print(id(str1),id(str2))  # 15662816 15662816
"""

# todo about wrapper装饰器
# 1.0
from functools import update_wrapper,wraps

def wrap1(func):
    def call_it(*args,**kwargs):
        """this call_it doc """
        a,b=args
        print(f"this is test get args: a is {a},b is {b}")

        return func(*args,**kwargs)
    return update_wrapper(wrapper=call_it,wrapped=func)

@wrap1
def hello(a,b):
    """this is hello doc """
    return a+b

#2.0 test wraps usage :

def wraps2(func):
    @wraps(func)
    def test_wraps(*args,**kwargs):
        """ this test wraps"""
        return func(*args,**kwargs)
    # 省略返回wrapper object func
    return test_wraps

@wraps2
def demo(a,b):
     """this is demo doc """
     return a*b

if __name__ == '__main__':
    a=hello(2,3)
    print("hello result is :",a,"  hello name is",hello.__name__,". hello doc is",hello.__doc__)

    b=demo(3,2)
    print("demo result is:",b,f"  demo name is {demo.__name__}. ",f"demo doc is {demo.__doc__}",end="")





