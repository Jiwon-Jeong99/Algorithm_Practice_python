import sys

new_id = sys.stdin.readline().rstrip()
import re

def to_lower(string):
    return string.lower();

def remove_special(string):
    regex = r'[^a-z0-9\-_.]'
    return re.sub(regex,'',string)

def combine_dot(string):
    regex = r'\.{2,}'
    return re.sub(regex, '.', string)
        
def remove_fbdot(string):
    regex = r'^\.|\.$'
    return re.sub(regex, '', string)

def add_a(string):
    if string == '':
        return(string.join('a'))
    else:
        return string

def remove_extra_string(string):
    if len(string) >= 16:
        string = string[:15]
        return re.sub(r'\.$','',string)
    else:
        return string

def repeat_last_string(string):
    while len(string) < 3 :
        string += string[len(string)-1]
    return string

def solution(new_id):
    a = to_lower(new_id)
    b = remove_special(a)
    c = combine_dot(b)
    d = remove_fbdot(c)
    e = add_a(d)
    f = remove_extra_string(e)
    answer = repeat_last_string(f)
    
    return answer

solution(new_id)

# import re

# def solution(new_id):
#     st = new_id
#     st = st.lower()
#     st = re.sub('[^a-z0-9\-_.]', '', st)
#     st = re.sub('\.+', '.', st)
#     st = re.sub('^[.]|[.]$', '', st)
#     st = 'a' if len(st) == 0 else st[:15]
#     st = re.sub('^[.]|[.]$', '', st)
#     st = st if len(st) > 2 else st + "".join([st[-1] for i in range(3-len(st))])
#     return st