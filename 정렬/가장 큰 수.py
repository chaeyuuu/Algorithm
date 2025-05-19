from itertools import permutations
def solution(numbers):
    answer = 0
    num_list = []
    perm = list(permutations(numbers))
    print(perm)
    for p in perm:
        temp = ''.join(map(str,p))
        print(temp)
        num_list.append(temp)
    
    num_list.sort(reverse=True)
    answer = str(num_list[0])
    print(answer)
    
    return answer