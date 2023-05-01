import sys

# def solution(arr):
#     h = len(arr) // 2
#     if sum([sum(i) for i in arr]) == len(arr)*len(arr[0]):
#         return [0,1]
#     elif sum([sum(i) for i in arr]) == 0:
#         return [1,0]
#     else:
#         return [sum(i) for i in zip(*[solution([i[:h] for i in arr[:h]])]),
#                             solution]
def solution(arr):
    answer = [0, 0]

    def check(size, x, y):
        if size == 1:
            answer[arr[y][x]] += 1
            return
        else:
            first = arr[y][x]

            for dy in range(size):
                for dx in range(size):
                    if first != arr[y + dy][x + dx]:
                        check(size // 2, x, y)
                        check(size // 2, x + size // 2, y)
                        check(size // 2, x, y + size // 2)
                        check(size // 2, x + size // 2, y + size // 2)
                        return
            answer[first] += 1
    check(len(arr),0,0)


    return answer