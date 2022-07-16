import itertools
ina = input()
count = 1
lenina = len(ina)
arrina = [0]*lenina
stacknum = []
stacknum2 = []
where = []
for i, arr in enumerate(ina):
    if arr == '(':
        arrina[i] = count
        stacknum.append(count)
        stacknum2.append(i)
        count += 1
    elif arr == ')':
        arrina[i] = stacknum.pop()
        where.insert(0, [i, stacknum2.pop()])
count -= 1

answer = []
case = []
for i in range(1, count+1):
    case.extend(list(itertools.combinations(where, i)))
for cas in case:
    tmpina = list(ina)
    for ca in cas:
        for c in ca:
            tmpina[c] = ' '
    answer.append(''.join(tmpina).replace(" ", ""))
answer = set(answer)
answer = list(answer)
for ai in sorted(answer):
    print(ai)