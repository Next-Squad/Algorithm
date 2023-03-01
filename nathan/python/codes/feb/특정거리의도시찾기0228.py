import sys
from collections import deque
input = sys.stdin.readline


if  __name__ == '__main__':
  n, m, k, x = map(int, input().split())
  dists = [int(1e9)] * n
  roads = [[] for _ in range(n)]
  for _ in range(m):
    a, b = map(int, input().split())
    roads[a-1].append(b-1)

  queue = deque()
  queue.append(x-1)
  dists[x-1] = 0
  while (queue):
    now = queue.popleft()
    dist = dists[now]
    for i in roads[now]:
      if dists[i] > dist + 1:
        dists[i] = dist+1
        queue.append(i)

  flag = False
  for i in range(n):
    if dists[i] == k:
      print(i+1)
      flag = True
  if not flag:
    print(-1)





