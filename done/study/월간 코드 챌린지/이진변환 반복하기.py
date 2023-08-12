def solution(s):
    zero_count = 0
    change = 0
    while(len(s) != 1):
        zero_count += s.count('0')
        str = s.replace('0','')
        length = len(str)
        s = format(length, 'b')
        change += 1
    
    return [change, zero_count]