import sys
n = int(sys.stdin.readline())
stones = list(map(int, sys.stdin.readline().split()))

def countMax(num):
    stack=[]
    answer=0
    count=0
    for stone in stones:
        if stone==num:
            stack.append(stone)
            count+=1
        else:
            if stack:
                stack.pop()
                count-=1
        answer=max(answer,count)
    return answer

print(max(countMax(1),countMax(2)))