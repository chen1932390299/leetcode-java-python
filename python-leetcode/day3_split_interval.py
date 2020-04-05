step = 2
n = 10
block = n / step
rangers = [[k, k + step] for k in list(range(1, n, step))]
print(rangers)
print(block)
#  [[1, 3], [3, 5], [5, 7], [7, 9], [9, 11]]
