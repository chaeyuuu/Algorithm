def solution(n, computers):
    answer = 0
    visited = [0] * n
    for v in range(n):
        if visited[v] == 0: # 방문 안 했으면
            bfs(v, visited, n, computers)
            answer += 1
    
    return answer
    
def bfs(v, visited, n, computers):
    # 방문했다고 처리
    visited[v] = 1
    # 큐에 등록
    queue = [v]
    print(queue)
    # 큐가 빌 때까지 
    while queue:
        v = queue.pop(0)
        print(v)
        for i in range(n):
            # 연결되어있는데 방문 안 했으면
            if computers[v][i] == 1 and visited[i] == 0:
                queue.append(i)
                visited[i] = 1