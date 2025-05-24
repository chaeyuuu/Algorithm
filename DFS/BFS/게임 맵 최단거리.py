from collections import deque
def solution(maps):
    n = (len(maps))
    m = (len(maps[0]))
    return -1 if bfs(0,0,n,m,maps)== 1 else bfs(0,0,n,m,maps)

def bfs(x,y,n,m,maps):
    dx = [0,0,-1,1]
    dy = [-1,1,0,0]
    
    queue = deque()
    queue.append((x,y))
    
    while queue:
        a,b = queue.popleft()
        for i in range(4):
            nx = a + dx[i]
            ny = b + dy[i]
            
            if 0<=nx<n and 0<=ny<m:
                if maps[nx][ny] == 1:
                    queue.append((nx,ny))
                    maps[nx][ny] = maps[a][b]+1
                    
    return maps[n-1][m-1]