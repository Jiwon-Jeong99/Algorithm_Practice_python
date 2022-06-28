s=input()
p=input()
#p의 접두사, 접미사 구하기
l=[0 for x in range(len(p))]
i=1
j=0
while i<len(p):    
    while j>0 and p[j]!=p[i]:
        j=l[j-1]
    if p[j]==p[i]:
        j+=1
        l[i]=j
    i+=1
j=0
for i in range(len(s)):
    while (j>0 and s[i]!=p[j]):
        j=l[j-1]
    if s[i]==p[j]:
        if j==len(p)-1:
            print("1")
            exit()
        else:
            j+=1
print("0")