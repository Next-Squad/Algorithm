import sys

input = sys.stdin.readline

str = input().rstrip()
one = 0
zero = 0
pre = str[0]
if pre == '0':
  zero+=1
else:
  one+=1

for i in range(1, len(str)):
  now = str[i]
  if pre != now:
    pre = now
    if now == '0':
      zero+=1
    else:
      one+=1

print(min(one, zero))
