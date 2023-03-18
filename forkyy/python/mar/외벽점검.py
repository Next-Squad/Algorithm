import math
from itertools import permutations


def solution(n, weak, dist):
    answer = math.inf
    weak_size = len(weak)
    weak = weak + [w + n for w in weak]
    cases = permutations(dist, len(dist))

    for start_index in range(weak_size):
        for workers in cases:
            count = 1
            position = start_index

            for i in range(1, weak_size):
                next_position = start_index + i
                diff = weak[next_position] - weak[position]

                if diff > workers[count - 1]:
                    position = next_position
                    count += 1
                    if count > len(dist):
                        break

            if count <= len(dist):
                answer = min(answer, count)

    if answer == math.inf:
        return -1

    return answer

# 1. 순열을 구해야함.


# 시작하는 취약지점을 돌아가며
# dist의 순열을 전부 돌려본다.
# ex) 1 지점부터 시작 -> 1번, 2번, 3번 관리자를 사용함
# ex) 5 지점부터 시작 -> 1번이 5번에서 시작 / 3번이 10번부터 시작. -> 2명의 관리자만 사용하면 됨.
