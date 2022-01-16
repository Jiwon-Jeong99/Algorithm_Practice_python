import sys


design = list(sys.stdin.readline().rstrip())
mark_1 = list(sys.stdin.readline().rstrip())
mark_2 = list(map(int, sys.stdin.readline().split()))

left = 0
perfect = 0
trash = 0

new_item = []


for j in range(len(mark_2)):
    for i in range(len(design)):
        if design[i] == mark_1[0]:
            new_item.append(mark_1[0])
            mark_1.pop(0)
            continue

        if design[i] != mark_1[0]:
            while design[i] != mark_1[0]:
                mark_1.pop(0)
                trash += 1

                if design[i] == mark_1[0]:
                    new_item.append(mark_1[0])
                    mark_1.pop(0)
                    break
            continue

    if len(mark_1) == 0:
        break

perfect = len(new_item) // len(design)
num = perfect + 1

print("#1 %d" % perfect)
print("#2 %d" % left)
print("#3 %d" % num)
print("#4 %d" % trash)
 
#뒤에 문자열이 있으면 프로그램 실행