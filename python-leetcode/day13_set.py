set=set() #无须的不重复的集合
#set.add({"k":"v"}) #unhashable type: 'dict'
#set.add([1,3]) #TypeError: unhashable type: 'list'
set.update("aaa") #TypeError: 'int' object is not iterable
set.add((1,3))
print(set) #{'a', (1, 3)}
set.update({"k":"v"})  #只保留key
print(set)
#set.remove("k2") #KeyError: 'k2'
set.remove("k")
print(set) #{(1, 3), 'a'}
###
a=(1,3)
print(tuple(a)) #(1,3)
# list <<====>> tuple
# dict ==>> list
dict1=dict()
dict1["k"]=1
print(list(dict1))  # ['k']
# set <==> list
print(list(set))  #['a', (1, 3)]
tuple1=(1,3,5)
print(tuple1.index(5)) # index(元素),返回元素索引
print(tuple1.count(1))
# set ==> tuple
print(tuple(set))  # ('a', (1, 3))

#对称差集
set2={3,5,10}
set1={1,3,5,7}
print(set2^set1)  # {1, 7, 10}
# 差集
print(set1-set2) #{1, 7}
print(set2-set1) # {10}
print(set1.difference(set2))
# union
print(set1|set2)
print(set1.union(set2))
# 交集
print(set1& set2)
print(set1.intersection(set2))

# clear
set4={1,2}
set4.clear()
print(set4)  # set()
