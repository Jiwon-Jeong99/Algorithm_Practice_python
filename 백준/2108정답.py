n = int(input())

nums = []
for _ in range(n) :
	nums.append(int(input()))

# 산술평균
print(round(sum(nums)/n))

# 중앙값
nums.sort()
print(nums[int((n-1)/2)])

# 최빈값
counts = dict()
for i in range(1,n+1) :
	counts[i] = []

maxCount = 1
count = 1
for j in range(1,n) :
	if nums[j] == nums[j-1] :
		count += 1
	else :
		counts[count].append(nums[j-1])
		if maxCount < count : maxCount = count
		count = 1
	if j == n-1 : 
		counts[count].append(nums[j])
		if maxCount < count : maxCount = count

if n == 1 :
	counts[1].append(nums[0])

counts[maxCount].sort()
if len(counts[maxCount]) == 1 :
	print(counts[maxCount][0])
else :
	print(counts[maxCount][1])

# 범위
print(nums[-1]-nums[0])