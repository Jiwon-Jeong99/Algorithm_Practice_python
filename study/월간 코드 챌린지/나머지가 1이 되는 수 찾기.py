def solution(n):
    for i in range(n):
        if n % (i+1) == 1:
            answer = i+1
            break
    return answer