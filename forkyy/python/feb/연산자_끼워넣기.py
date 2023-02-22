import sys

input = sys.stdin.readline


def plus(a, b): return a + b


def minus(a, b): return a - b


def multiple(a, b): return a * b


def divide(a, b): return int(a / b)


calcs = [plus, minus, multiple, divide]


def calculate(num, a, b): return calcs[num](a, b)


def dfs(cur_num, next_idx):
    global max_res
    global min_res

    if next_idx == n:
        max_res = max(max_res, cur_num)
        min_res = min(min_res, cur_num)
        return

    for i in range(4):
        if counts[i] > 0:
            counts[i] -= 1
            dfs(calculate(i, cur_num, nums[next_idx]), next_idx + 1)
            counts[i] += 1


n = int(input())
nums = [int(x) for x in input().split()]
counts = [int(x) for x in input().split()]
max_res = -1e9
min_res = 1e9

dfs(nums[0], 1)

print(max_res)
print(min_res)
