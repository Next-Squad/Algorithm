import sys
from itertools import combinations

input = sys.stdin.readline

n, m = list(map(int, input().split()))
cities = [[] for _ in range(n)]
stores, homes = [], []

# 입력받기
for i in range(n):
    cities[i] += list(map(int, input().split()))

# 가게, 집 목록 저장
for i in range(n):
    for j in range(n):
        if cities[i][j] == 1:
            homes.append([i, j])
        elif cities[i][j] == 2:
            stores.append([i, j])

result = 1e9

for t in combinations(stores, m):
    temp_result = 0
    for hx, hy in homes:
        dist = 1e9
        for sx,sy in t:
            dist = min(dist, abs(hx - sx) + abs(hy - sy))
        temp_result += dist
    result = min(result, temp_result)

print(result)
