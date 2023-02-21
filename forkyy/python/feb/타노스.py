import sys

input = sys.stdin.readline

val = list(input())

o = val.count('1')//2
z = val.count('0')//2

for _ in range(o):
    val.pop(val.index('1'))

for _ in range(z):
    reverse = val[::-1]
    index = -(reverse.index('0'))
    val.pop(index-1)

print(''.join(val))

# ------------------
# 1차 시도
# 입력 받을때 0 개수, 1개수 세기.
# 센 개수를 절반으로 나눠서 조합
# 문자로 변환해서 가장 빠른 문자열 조합을 반환.

# val = list(input())
# z, o = val.count('0')//2, val.count('1')//2
# arr = ['0'for _ in range(z)] + ['1'for _ in range(o)]
# result = [''.join(list(x)) for x in list(permutations(arr, len(arr)))]
# print(result[0])