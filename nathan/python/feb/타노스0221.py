import sys

input = sys.stdin.readline
tmp_string = input().rstrip()
zero, one = 0, 0
for i in range(len(tmp_string)):
  if tmp_string[i]== '0':
    zero+=1
  else:
    one+=1

zero /= 2
one /= 2
available = [0] * len(tmp_string)
for i in range(len(tmp_string)):
  if one > 0:
    if tmp_string[i] == '1':
      one-=1
      available[i]-=1
  else:
    break

for i in range(len(tmp_string) - 1, -1, -1):
  if zero > 0:
    if tmp_string[i] == '0':
      zero-=1
      available[i]-=1
  else:
    break
result = ""
for i in range(len(tmp_string)):
  if available[i] == 0:
    result += str(tmp_string[i])

print(result)
