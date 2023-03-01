import sys
from collections import defaultdict
from collections import deque

input = sys.stdin.readline


n, m, k, x = map(int, input().split(' '))
city = defaultdict(list)
dists = [1e9] * (n+1)

for _ in range(m):
    start, end = map(int, input().split(' '))
    city[start].append(end)


def bfs(start_point):
    q = deque()
    dists[start_point] = 0
    q.append(city[start_point])
    depth = 0

    while q:
        cities = q.popleft()
        temp = []
        for c in cities:
            if dists[c] > depth:
                dists[c] = depth + 1
                if city[c]:
                    temp += city[c]
        if temp:
            q.append(temp)
        depth += 1


bfs(x)
result = []
for i in range(len(dists)):
    if dists[i] == k:
        result.append(i)
if not result:
    print(-1)
else:
    for i in result:
        print(i)
