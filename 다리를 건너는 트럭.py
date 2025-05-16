from collections import deque
def solution(bridge_length, weight, truck_weights):
    # bridge_length: 다리에 올라갈 수 있는 트럭의 수
    # weight: 다리가 견딜 수 있는 무게
    # truck_weights: 트럭의 무게 
    # second: 모든 트럭이 다리를 건너는데 필요한 초
    second = 0
    truck_weights = deque(truck_weights) # 트럭 무게 배열 
    move = deque([0]* (bridge_length)) # 현재 다리를 지나는 중인 트럭 (queue)
    info = [] # 현재 다리 위에 있는 트럭 무게 (truck_bridege)
    
    # 트럭이 다 건널 때까지
    while len(move):
        # 다 건너면 삭제
        if move[0] != 0:
            # 건너고 있는 트럭 무게 배열에서 삭제
            info.pop(0)
        # 시간 지났으니까 삭제
        move.popleft()
        
        if truck_weights:
            # 트럭 출발
            truck = truck_weights.popleft()
            # 이미 지나고 있는 건너는 트럭의 무게가 weight 보다 크면 취소
            if sum(info) + truck > weight:
                truck_weights.appendleft(truck)
                move.append(0)
                # 무게가 되면 
            else:
                info.append(truck)
                move.append(truck)
        second +=1
    return second