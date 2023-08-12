def solution(array, commands):
    answer = []
    for i in range(0, len(commands)):
        n = array[commands[i][0]-1:commands[i][1]]
        n.sort()
        k = commands[i][2]-1
        answer.append(n[k])
    return answer
