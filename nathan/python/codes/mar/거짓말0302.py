import sys
input = sys.stdin.readline

def union(a:int, b:int, parents:list):
  parentA = find(a, parents)
  parentB = find(b, parents)
  if a < b:
    parents[parentB] = parentA
  else:
    parents[parentA] = parentB


def find(a:int, parents:list):
  if parents[a] != a:
    parents[a] = find(parents[a], parents)
  return parents[a]

if __name__ == '__main__':
  n, m = map(int, input().split())
  parents = [i for i in range(n+1)]
  truth = list(map(int, input().split()))
  if (truth[0] > 0):
    for i in range(1, len(truth)):
      parents[truth[i]] = truth[1]
  parties = []
  for _ in range(m):
    tmp = list(map(int, input().split()))
    parties.append(tmp[1:])
    if tmp[0] == 1:
      continue
    tmp_parent = find(tmp[1], parents)
    for i in range(2, len(tmp)):
      if tmp_parent != find(tmp[i], parents):
        union(tmp_parent, tmp[i], parents)

  cnt = 0
  if truth[0] > 0:
    for party in parties:
      if find(party[0], parents) != find(truth[1], parents):
        cnt+=1
  else:
    cnt = m
  print(cnt)


