import numpy as np

a= [80, 46, 21, 18, 79, 78, 95, 7, 91, 4]
length = len(a)
for i in range(length):
    for j  in range(length-1-i):
        if a[j]>a[j+1]:
            a[j],a[j+1]=a[j+1],a[j]
    print(a)
