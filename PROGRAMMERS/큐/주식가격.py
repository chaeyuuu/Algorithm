from collections import deque
def solution(prices):
    answer = []
    queue = deque(prices)
    count = 0
    
    while queue:
        price = queue.popleft()
        if any(price>num for num in queue):
            # 하나라도 떨어진게 있는 경우
            for i in range(len(queue)):
                if price<=queue[i]:
                    count+=1
                else:
                    count = i+1
                    break
            answer.append(count)
        else:
            # 떨어진게 없는 경우
            answer.append(len(queue))
        
    return answer