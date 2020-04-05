a = [1, 3, 4]
b = [2, 4, 6]
# intersection
print(set(a) & set(b))
# diffrence set
print(set(a) ^ set(b))
# union
print(set(a) | set(b))
# a diff b,b have but a not,按左边为准
print(set(a).difference(set(b)))
print(set(b).difference(set(a)))
