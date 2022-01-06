dic_1 = {}
dic_2 = {}

name = input("이름은 : ")
age = input("나이는 : ")
hobby = input("취미는 : ")

dic_2["나이"] = age
dic_2["취미"] = list(hobby.split(","))
dic_1[name] = dic_2

print(dic_1)

name = input("이름은 : ")
age = input("나이는 : ")
hobby = input("취미는 : ")

dic_2["나이"] = age
dic_2["취미"] = list(hobby.split(","))
dic_1[name] = dic_2

print(dic_1)

search_name = input("회원검색 :")
r_age = dic_1[search_name]["나이"]
r_hobby = dic_1[search_name]["취미"]

print(f"{search_name}님은 {r_age}세에 {r_hobby}를 좋아합니다.")


#dic_1 = {'홍길동': {'나이': 30, '취미': '농구,축구,배구'}, '고길동': {'나이': 48, '취미': '영화,스키,낚시'}}

# dic1 = {"홍길동" : dic_2 }
