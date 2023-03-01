import sys, copy

input = sys.stdin.readline

def backtracking(arr):
  global results, operators, n

  if len(arr) == n-1:
    results.append(arr)
    return

  for i in range(4):
    if operators[i] > 0:
      operators[i]-=1
      tmp = copy.deepcopy(arr)
      tmp.append(i)
      backtracking(tmp)
      operators[i]+=1

def operate():
  global results, nums, max_num, min_num
  tmp = 0
  for result in results:
    tmp = nums[0]
    for i in range(len(nums)-1):
      if result[i] == 0:
        tmp += nums[i+1]
      elif result[i] == 1:
        tmp -= nums[i+1]
      elif result[i] == 2:
        tmp *= nums[i+1]
      else:
        tmp = int(tmp/nums[i+1])
    max_num = max(tmp, max_num)
    min_num = min(tmp, min_num)

if __name__ == "__main__":
  n = int(input())
  nums = list(map(int, input().split()))
  operators = list(map(int, input().split()))
  results = []

  max_num = int(1e9) * (-1)
  min_num = int(1e9)

  backtracking([])
  operate()
  print(max_num)
  print(min_num)
