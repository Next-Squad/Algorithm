import sys

input = sys.stdin.readline

n, m = map(int, input().split(' '))
true_list = set(map(int, input().split(' ')[1:]))
party_list = []

for _ in range(m):
    party_list.append(set(map(int, input().split(' ')[1:])))

if not true_list:
    print(m)
else:
    for _ in range(m):
        for p in party_list:
            if p & true_list:
                true_list = true_list.union(p)
    count = 0
    for p in party_list:
        if not p & true_list:
            count += 1
    print(count)



# 진실을 말하는 사람들이 있으면 진실을 말해야됨
# 모르는 사람들만 있으면 거짓말해도 됨
# 두가지 모두에 참여하는 사람이 있는 경우도 x
