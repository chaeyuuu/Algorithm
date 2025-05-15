from collections import deque

def solution(s):
    answer = True
    temp = deque()
    list_s = deque(s)
    while len(list_s) > 0:
        if list_s[0] == ')':
            if '(' in temp:
                list_s.popleft()
                temp.popleft()
            else:
                return False
        else:
            # '(' 인 경우 
            # '(' 다음에 바로 ')'인 경우 | '(' 다음에 또 '(' 인 경우
            temp.append(list_s.popleft())
    if len(temp) > 0 :
        return False
    return True