# enumerate
: 순서가 있는 자료형  (list, set, tuple, dictionary, string)
을 입력으로 받았을 때 인덱스와 값을 포함하여 리턴

* 인덱스와 값을 동시에 접근하고 싶을 때 사용하면 좋음
```
queue = deque([(index, priority) for index, priority in enumerate(priorities)])
```

위의 코드는 priorities 라는 배열에 인덱스를 붙여서 튜플 형식으로 deque로 저장

->
!! `queue = deque(enumerate(priorities))` 
이렇게 해도 됨 훨씬 간단하게 할 수 있음 ❗️



# any & all
- any(): 하나라도 True인게 있으면 True
- all(): 모두 True여야 True 반환

ex)
```
cur = 3
temp = [1,3,6,2]
if any(cur<num for num in temp):
	print("There exist number that is larger than 3")
```

- 대소비교를 할 때 사용하면 실행시간을 많이 줄 일 수 있음 