def solution(array, commands):
    answer = []
    
    for command in commands:
        # i, j, k = commands[command][0], commands[command][1], commands[command][2]
        i,j,k = command
        temp=(array[i-1:j])
        temp.sort()        
        
        answer.append(temp[k-1])
    
    return answer