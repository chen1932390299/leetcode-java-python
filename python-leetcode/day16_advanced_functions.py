
def foo(iteral):
    return iteral[0]
# todo sample own define map
a=[[1,"a"],[2,"b"]]
res= list(map(foo,a)) # <<=====>> res=list(map lambda x:x[0],a) :--> lambda func:expression
print(res) # [1, 2]

# todo sample2 about  map
result=list(map(str,a))  # change all elements to string type

# todo sample filter own define
b=[1,3,3,5,7]
my_filter=list(filter(lambda x:x !=3,b))
print(my_filter) # [1, 5, 7]

# todo sample sort own define
set={"a":1,"Admin":"test","44":77}
my_sorted = sorted(set,key=lambda x:x[0],reverse=False)
print(my_sorted)  # ['44', 'Admin', 'a']  by ascii ascending digital-->UpperLetter--> lowerLetter
