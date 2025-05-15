def solution(s):
    answer = True
    temp = []
    list_s = list(s)
    while len(list_s)>0:
        if list_s[0] == ')':
            if '(' in temp:
                list_s.pop(0)
                temp.pop(0)
            else:
                return False
        else:
            # '(' 인 경우 
            # '(' 다음에 바로 ')'인 경우 | '(' 다음에 또 '(' 인 경우
            temp.append(list_s.pop(0))
    if len(temp) > 0 :
        return False
    return True