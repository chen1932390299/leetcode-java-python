# todo 可迭代对象iterable：1.序列 （字符串，元组，列表） 2.迭代器 （特殊的迭代器：生成器） 3.字典 dict

#todo 什么样的对象称之为可迭代对象？
# 定义了__iter__方法的对象，调用该方法会返回一个迭代器对象.

#todo 什么叫做迭代器,如使用iter定义list=["a","b","c"] ,it=iter(list)，也就是使用iter方法来实现一个可迭代对象list成为一个迭代器?
# 迭代器就是定义__next__ 方法的对象。每次调用上述方法就返回迭代器一个值，没有就抛出StopIteration异常


def test_iter():
    a = 8
    for it in iter(a):
        print(it)
    # TypeError: 'int' object is not iterable


# todo python 生成器主要分为两种类型：
# 第一种，生成器函数返回的生成器,，但是，使用yield而不是return语句返回结果。
# yield语句一次返回一个结果，在每个结果中间，挂起函数的状态，以便下次从它离开的地方继续执行。
def foo_gen():
    print("start.....")
    yield 1
    print("this is 1")
    yield 2
    print("this is 222")
    yield 3
    print("this is 333\nend.....")


g1 = foo_gen()  # <class 'generator'>
for i in g1:
    print(i)

# 第二种，生成器表达式(generator expression)返回得到的生成器
g = (i for i in (1, 2, 3))
print(type(g))


# todo 注意事项：1.生成器是只能遍历一次的, 2.生成器是一类特殊的迭代器。

#迭代器如何应用？其实调用Python内置函数next函数就可以，该函数会接受一个迭代器对象
demo=["a","b","c"]
it=iter(demo)
print(next(it))
print(next(it))

#关于生成器：
# 1、生成器相关概念介绍
# 生成器：用于按需生成元素的对象。在Python社区中大多数时候都把迭代器和生成器视作同一概念。
#
# 生成器函数：拥有yield关键字的Python函数。
# 生成器表达式：制造生成器的工厂，支持惰性产值。
# 生成器工厂函数：返回生成器的函数，定义体中可以没有yield关键字。
#
# 生成器函数与生成器表达式优点比较：
#
# 生成器函数：使用重复使用的情景，也可以作为协程使用。
# 生成器表达式：代码简洁易读。
# Tips:生成器表达式作为单参数传入时无须写一对括号，而多参数时须将小括号加上。
# todo 总结：
    # 可迭代对象必须是定义了__iter__方法
    #迭代器 是具备__next__方法的可迭代对象
    #生成器generator：是一种特殊的迭代器，它可以生成一个可迭代的迭代器