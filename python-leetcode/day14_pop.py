a=[1,3,5,9,8]
print(a.pop()) # 默认pop index -1 ,可以指定索引

dict1={"k1":1,"a":"avalue"}
#print(dict1.pop("k11")) # raise KeyError: 'k11'
print(dict1.pop("k11","not found key ")) # not found key
print(dict1.pop("k1")) # return key value
print(dict1)  # {'a': 'avalue'}
print(dict1.get("a",None)) # avalue
# create dict
d2=dict.fromkeys(["1","3"],888) # {'1': 888, '3': 888}
print(d2)

# del dict and clear
del d2["1"]
print(d2)  #{'3': 888}
d2.clear()
print(d2)  # {}
