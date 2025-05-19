from itertools import permutations

def solution(clothes):
    dic = {}
    answer = 1
    
    for clothe, category in clothes:
        if category not in dic:
            dic[category] = [] # 없으면 배열 생성
        dic[category].append(clothe)
    print(dic)
    print(dic.items())
    
    # 의상을 입는 경우의 수 a*b + a + b = (a+1)(b+1)
    
    for key, value in dic.items():
        answer *= (len(value)+1)
        
    return answer - 1