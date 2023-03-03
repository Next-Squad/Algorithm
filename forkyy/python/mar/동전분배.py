import sys

input = sys.stdin.readline

for _ in range(3):
    n = int(input())
    total_amount = 0
    coins = dict()
    for _ in range(n):
        t, c = map(int, input().split())
        coins[t] = c
        total_amount += t * c

    if total_amount % 2 == 1:
        print(0)
        continue

    