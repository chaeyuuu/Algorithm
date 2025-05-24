# words 안에 있는 알파벳 저장
# target 알파벳이 words 안에 없으면 0
# 있으면 변환 bfs
from collections import deque

def solution(begin, target, words):
    answer = 0
    
    if target not in words:
        return 0
    else:
        answer = bfs(begin,target,words)
    return answer

def bfs(begin,target,words):
    queue = deque()
    queue.append((begin,0))
    
    while queue:
        cur, step = queue.popleft()
        
        if cur == target:
            return step
        
        for word in words:
            count = 0
            for i in range(len(word)):
                if word[i] != cur[i]:
                    count +=1
            
            if count == 1:
                # 단계 증가
                queue.append((word,step+1))