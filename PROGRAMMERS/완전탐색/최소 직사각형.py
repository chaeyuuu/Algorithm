def solution(sizes):
    for size in sizes:
        if size[1] > size[0]:
            size[0], size[1] = size[1], size [0]
    sizes.sort(reverse = True)
    
    x, y = sizes[0][0], sizes[0][1]
    
    for i in range(len(sizes)-1):
        if y < sizes[i+1][1]:
            y = sizes[i+1][1]
            
    return x * y

def solution(sizes):
    row = 0
    col = 0
    for x, y in sizes:
        if x < y:
            x, y = y, x
        row = max(row, x)
        col = max(col, y)
    
    return row*col