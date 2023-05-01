# 이진탐색
# lower bound

# 특정 score 이상 점수가 필요하니 score 대로 오름차순
# dict key : 키워드, dict value : 점수

from collections import defaultdict
from itertools import combinations

def solution(info, query) : 
    answer = []
    info_dict = defaultdict(list)
    
    #1. info로 dict 생성
    for i in info:
        row = i.split()
        info_keylist = row[:-1] #점수를 제외한 내용을 key로
        info_value = int(row[-1]) #점수를 value로
        
        #1.1 하나의 info에 대한 경우의 수 16개 = key
        for i in range(5):
            for c in combinations(info_keylist,i):
                info_key = ''.join(c)
                info_dict[info_key].append(info_value) #하나의 info에 대한 가능한 경우를 key, 점수를 value
                
        for key in info_dict.keys():
            info_dict[key].sort()
            
        #2. query 정리
        for q in query:
            qrow = q.split(' ')
            query_score = int(qrow[-1])
            query = qrow[:-1]
            
            #2.1 query_keylist 처리: and 제거
            for _ in range(3):
                query.remove('and')
            #2.2 query_keylist처리 : -제거
            while '-' in query:
                query.remove('-')
            query_key = ''.join(query)
            
            #3. lower bound 사용해서 query_score보다 큰 점수 개수 구하기
            if query_key in info_dict:
                scoreList = info_dict[query_key]
                
                if len(scoreList) > 0:
                    start = 0
                    end = len(scoreList)
                    while start < end:
                        mid = (start + end) // 2
                        if scoreList[mid] >= query_score:
                            end = mid
                        else:
                            start = mid + 1
                            
                    answer.append(len(scoreList)-start)
            else:
                answer.append(0)
        return answer
    
# from itertools import combinations
# from bisect import bisect_left

# # java backend junior pizza 를 "backendjuniorpizza", "junior pizza" ... ""
# # 위와 같이 가능한 모든 경우의 수 dict 에 넣기
# def make_case(x, infoDict):
#     tempArr = x.split(" ")
#     score = int(tempArr[-1])
#     for idx in range(5):
#         for c in combinations(tempArr[:-1], idx):
#             key = "".join(c)
#             if key in infoDict:
#                 infoDict[key].append(score)
#             else:
#                 infoDict[key] = [score]

# # 이진탐색으로 queryScore 보다 큰 점수들의 개수 반환
# def find_answer(key, queryScore, infoDict):
#     if key in infoDict:
#         return len(infoDict[key]) - bisect_left(infoDict[key], queryScore)
#     return 0

# def solution(info, query):
#     infoDict = dict()
    
#     for x in info:
#         make_case(x, infoDict)
    
#     for key in infoDict.keys():
#         infoDict[key].sort()
        
#     answer = []
#     for x in query:
#         tempArr = list(y for y in x.replace("and", " ").replace("-", "").split(" ") if len(y) > 0)
#         queryScore = int(tempArr[-1])
#         if len(tempArr) == 1:
#             answer.append(find_answer("", queryScore, infoDict))
#         else:
#             answer.append(find_answer("".join(tempArr[:-1]), queryScore, infoDict))
            
#     return answer