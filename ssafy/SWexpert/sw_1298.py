test_case = int(input())

for i in range(test_case):
    memory = list(map(int, input()))
    cnt = 0
    # memory 길이에 따라 초기화된 메모리
    initial = [0 for _ in range(len(memory))]

    for j in range(len(memory)):
        if memory[j] != initial[j]:
            initial[j:] = [memory[j] for _ in range(len(memory)-j)]
            cnt += 1

    print("#%d" % (i+1), cnt)
