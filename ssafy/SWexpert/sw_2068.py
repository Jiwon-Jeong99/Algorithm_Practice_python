test_case = int(input())
for i in range(test_case):
    num_list = list(map(int, input().split()))
    max_num = max(num_list)
    print("#%d %d" % (i+1, max_num))
