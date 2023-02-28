import sys

input = sys.stdin.readline

n = int(input())
nums = list(map(int, input().split(' ')))

p1, p2 = 0, n-1

cur = 1e9
result = []

while p1 < p2:
    val = abs(nums[p1] + nums[p2])

    if val < cur:
        cur = val
        result = [nums[p1], nums[p2]]

    if nums[p1] + nums[p2] == 0:
        break
    elif nums[p1] + nums[p2] < 0:
        p1 += 1
    else:
        p2 -= 1


print(result[0], result[1])


