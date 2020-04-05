"""
25.Python的可变类型和不可变类型
答：可变类型，列表、字典、可变集合；不可变类型，数字、字符串、元组、不可变集合
"""
print(1 and 0 or 3) # 与或非
print(oct(30))


# type transfer
# int -> float
a=2
print(f"id of a is {id(a)}")
print(float(2)) # 2.0
print(str(2.0))
# str --> list
b="a,b,c"
print(list(b))  # ['a', ',', 'b', ',', 'c']
# list --> str
list1=["a","b"]
print("-".join(list1)) # a-b

# todo 用一句话来概括上述过程就是：python中的不可变数据类型，不允许变量的值发生变化，
#   如果改变了变量的值，相当于是新建了一个对象，而对于相同的值的对象，在内存中则只有一个对象，
#   内部会有一个引用计数来记录有多少个变量引用这个对象；可变数据类型，允许变量的值发生变化，即如果对变量进行append、
#   += 等这种操作后，只是改变了变量的值，而不会新建一个对象，变量引用的对象的地址也不会变化，不过对于相同的值的不同对象，
#   在内存中则会存在不同的对象，即每个对象都有自己的地址
#   相当于内存中对于同值的对象保存了多份，这里不存在引用计数，是实实在在的对象。”

c=2
print(f"integer 4 id is {id(a)}",f"integer 2 id is {id(c)}")
b="str1"
b2="str1"
print(f"str b id is {id(b)}",f" str b2 id is {id(b2)}")
d1=[1,2,3]
d2=[1,2,3]
print(id(d1),id(d2))  # [1,2,3]  list value same but addr not same 48448976 48450136

p=101
print(p//3)