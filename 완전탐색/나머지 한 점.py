def solution(v):
    answer = []
    x_list, y_list = {},{}

    for x, y in v:
        if x not in x_list:
            x_list[x] = 0
        x_list[x] += 1
        
        if y not in y_list:
            y_list[y] = 0
        y_list[y] += 1
    
    print(x_list)
    print(y_list)
    
    for x in x_list:
        if x_list[x] == 1:
            answer.append(x)
        
    for y in y_list:
        if y_list[y] ==1:
            answer.append(y)

    return answer