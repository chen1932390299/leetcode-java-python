k=["hello","dooo","kitty","alphago"]
index=0
length=len(k)
while index < length:
    if "do" in k[index]:
        del k[index]
        length -=1
        continue
    index +=1

# del  list element ,remove first occured element
a=["a","b"]
del a[0]
print(a) # ["b"]

# list  filter
print(filter(lambda x:x=="b",a))  # <filter object at 0x03006B70
print(list(filter(lambda x:x=="b",a)))# ['b']