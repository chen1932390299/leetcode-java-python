# coding=utf-8
# todo Permutations  a,b,c,d combine with diff string all situations
import itertools

# 排列，要求顺序
res = list(itertools.permutations(["a", "b", "c", "d"], 4))
print(res)
print(len(res))
print(len(set(res)))
# 组合,不要求顺序
combines = list(itertools.combinations(["a", "b", "c", "d"], 2))
print(combines)
print(len(combines))
print(len(set(combines)))


#example :
import itertools


def foo(it):
    if len(list(set(j) & set(it))) >= 0 and (len(list(set(k) & set(it))))<=1:
        return it


if __name__ == '__main__':
    j = ["a", "b", "c"]
    k = [1, 2, 3]
    q = j + k
    sums=[]
    for i in range(0, 7):
        res = list(itertools.combinations(q, i))
        sums.extend(res)

    print(sums)
    # c = [''.join(list(map(str,i))) for i in list(map(foo, sums)) if i]
    c = [i for i in list(map(foo, sums)) if i!=None]
    for o in c:
        print(o)
    print(len(c))


