def solution(numbers):
    answer = 0
    numbers = list(map(str, numbers))
    
    numbers.sort(key=lambda x: x*3, reverse = True)
    # print(numbers)
    result = ''.join(numbers)    
    # print(result)
    
    if result[0] == '0':
        return "0"
    
    return str(result)