import copy

"""23.简述Python的深浅拷贝以及应用场景？

答：浅拷贝是只仅仅拷贝数据集合的第一层数据(多维数组），深拷贝指的是拷贝数据集合的所有层。所以对于只有一层的
数据几个来说深浅拷贝的意义是一样的，如字典、元祖、集合、列表等。
对于数字和字符串而言，无意义，因其永远指向一个内存地址。"""
a = [1, 2, [3, 4]]
b = copy.copy(a)
c = copy.deepcopy(a)
print(b, c)
a[2][0] = "cf"
print(b, c)
# [1, 2, [3, 4]] [1, 2, [3, 4]]
# [1, 2, ['cf', 4]] [1, 2, [3, 4]]
