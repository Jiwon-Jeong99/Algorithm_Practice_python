def solution(n):
    answer = 0
    
    three_str = ''
    while n >= 1:
        n,b = divmod(n,3)
        three_str += str(b)
    answer = int(three_str, 3)

    return answer