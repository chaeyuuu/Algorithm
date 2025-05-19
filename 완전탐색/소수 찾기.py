from itertools import permutations, combinations

def is_prime(number):
    if number < 2:
        return False
    for i in range(2, number):
        if number % i ==0:
            return False
    return True
    

def solution(numbers):
    answer = 0
    num_list = list(numbers)
    answer_list = []
    
    for i in range(1, len(num_list)+1):
        # num_list에서 i자리 순열 구함 (1자리~x자리)
        perms = permutations(num_list, i)
        for p in perms:
            # 튜플 형태로 반환되는거 join
            num = int(''.join(p))
            answer_list.append(num)
            
    for number in set(answer_list):
        num = is_prime(number)
        if num:
            answer+=1
  
    return answer