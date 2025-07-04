def solution(numbers, target):
    results = [0]
    count = 0
    
    for num in numbers:
        temp = []
        
        for result in results:
            temp.append(result + num)
            temp.append(result - num)
        
        results = temp
        
    for result in results:
        if result == target:
            count += 1
    
    return count