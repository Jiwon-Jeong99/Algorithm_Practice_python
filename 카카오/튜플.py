import sys

def solution(s):
    s = s[2:-2].split("},{")
    arr = []
    for i in range(len(s)):
        S = s[i].split(",")
        arr.append(set(S))
    
    arr.sort(key=lambda x: len(x))
    
    res = set()
    answer = []
    for k in arr:
        temp = k - res
        answer.append(list(temp)[0])
        res = res | temp
        
    answer = [int(i) for i in answer]
    return answer
    