def solution(progresses, speeds):
    answer = []
    day = 0
    count = 0
    # 진행할 작업이 없을 때까지 진행
    while len(progresses) > 0:
        if progresses[0] + day * speeds[0] >= 100:
            # 끝난 count 증가
            count += 1
            # 작업 끝난 애들은 삭제
            progresses.pop(0)
            speeds.pop(0)
        else:
            # 100이 안 넘는데 count가 0보다 큼
            # 즉, 배포해야할 작업이 존재함
            if count > 0: 
                answer.append(count)
                # 다시 으로 초기화
                count = 0
            # day를 100이 안 넘는 경우에만 증가시켜야함 
            # -> 뒤에 기능이 먼저 개발될 수도 있기 때문
            day += 1
        
    answer.append(count)
    return answer