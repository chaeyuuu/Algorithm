def solution(nums):
    # set은 중복 허용 안 해서 그 개수, //2 한 개수 중 작은거 선택
    return min(len(set(nums)), len(nums)//2)