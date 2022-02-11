def solution(d, budget):
    count = 0
    d.sort()
    for i in d:
        if budget - i >= 0:
            count += 1
            budget -= i
        else:
            break

    return count
