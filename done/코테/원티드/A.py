import sys
count = sys.stdin.readline();
stone = sys.stdin.readline().split()

left_list = []
right_list = []
left = 0
right = 0
for i in range(len(stone)-1):
    if stone[i] == stone[i+1]:
        if stone[i] == '1':
            left += 1
        if stone[i] == '2':
            right += 1
    if stone[i] != stone[i+1]:
        if stone[i] == '1':
            left_list.append(left+1)
            left = 0
        if stone[i] == '2':
            right_list.append(right+1)
            right = 0
    
left_max = max(left_list)
right_max = max(right_list)
max_stone = max(left_max, right_max)
print(max_stone)