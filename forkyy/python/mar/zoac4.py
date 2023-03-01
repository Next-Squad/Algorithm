from math import ceil
import sys

input = sys.stdin.readline

h, w, n, m = map(int, input().split(' '))

r = h / (n + 1)
c = w / (m + 1)

print(ceil(r) * ceil(c))
