from collections import deque

def solution(priorities, location):
    answer = 0
    # deque로 튜플 형식으로 집어넣음
    queue = deque([(index, priority) for index, priority in enumerate(priorities)])
    
    while len(queue) > 0:
        # 프로세스 하나 뺌
        temp = queue.popleft()
        # 우선순위 높은거 있으면 다시 넣고
        if any(temp[1]<num[1] for num in queue):
            queue.append(temp)
        else:
            # 높은 거 없음
            answer += 1
            # 위치 비교
            if temp[0] == location:
                return answer