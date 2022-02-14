def solution(nums):
    maximum = len(nums)/2
    # set로 바꿔서 중복 제거
    my_set = set(nums)
    # 다시 list로 재정렬
    new_list = list(my_set)
    count = len(new_list)
    if maximum > count:
        return count
    else:
        return maximum
