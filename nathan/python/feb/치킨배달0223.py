import sys, copy

input = sys.stdin.readline


def count(matrix):
  global n, homes, chickens
  for i in range(n):
    for j in range(n):
      if matrix[i][j] == 1:
        homes.append((i, j))
      elif matrix[i][j] == 2:
        chickens.append((i, j))

def dfs(arr, start, visited):
  global chickens, results, m
  if len(arr) == m:
    results.append(arr)
    return

  for i in range(start, len(chickens)):
    if not visited[i]:
      visited[i] = True
      tmp = copy.deepcopy(arr)
      tmp.append(i)
      dfs(tmp, i+1, visited)
      visited[i] = False

def get_dist():
  global homes, chickens, results
  answer = int(1e9)
  for result in results:
    tmp = [int(1e9)] * len(homes)
    for i in range(len(homes)):
      for r in result:
        tmp[i] = min(tmp[i], abs(chickens[r][0]-homes[i][0]) + abs(chickens[r][1]-homes[i][1]))

    answer = min(answer, sum(tmp))
  return answer

if __name__ == "__main__":
  n, m = map(int, input().split())
  matrix = []
  homes = []
  chickens = []
  results = []
  for i in range(n):
    matrix.append(list(map(int, input().split())))

  count(matrix)
  dfs([], 0, [False]*len(chickens))
  print(get_dist())
