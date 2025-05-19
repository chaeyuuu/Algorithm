# 🕶️ programmers
프로그래머스 알고리즘 정복하기 🕶️

## 😭 TIL
### enumerate
: 순서가 있는 자료형  (list, set, tuple, dictionary, string)
을 입력으로 받았을 때 인덱스와 값을 포함하여 리턴

* 인덱스와 값을 동시에 접근하고 싶을 때 사용하면 좋음
```python
queue = deque([(index, priority) for index, priority in enumerate(priorities)])
```

위의 코드는 priorities 라는 배열에 인덱스를 붙여서 튜플 형식으로 deque로 저장

->
!! `queue = deque(enumerate(priorities))` 
이렇게 해도 됨 훨씬 간단하게 할 수 있음 ❗️



### any & all
- any(): 하나라도 True인게 있으면 True
- all(): 모두 True여야 True 반환

ex)
```python
cur = 3
temp = [1,3,6,2]
if any(cur<num for num in temp):
	print("There exist number that is larger than 3")
```

- 대소비교를 할 때 사용하면 실행시간을 많이 줄 일 수 있음 

### counter
: 데이터 개수를 셀 때 유용한 클래스
`from collections import Counter`

중복된 데이터가 저장된 배열이 들어오면 각 원소가 몇 번씩 나오는지 저장된 객체 획득 가능
```python
>>> Counter(['red', 'blue', 'red', 'green', 'blue', 'blue'])
Counter({'blue': 3, 'red': 2, 'green': 1})
```


```python
>>> Counter("hello world")
Counter({'h': 1, 'e': 1, 'l': 3, 'o': 2, ' ': 1, 'w': 1, 'r': 1, 'd': 1})
```


- 대괄호를 이용하여 키로 값을 읽을 수도 있음
```python
>>> counter["o"], counter["l"]
(2, 3)
```

-  특정 키에 해당하는 값 갱신 가능
```python
counter["l"] += 100
counter["h"] -= 1
>>> Counter({'h': 0, 'e': 1, 'l': 103, 'o': 2, ' ': 1, 'w': 1, 'r': 1, 'd': 1})
```
-  in 키워드로 특정 키가 존재하는지 확인 가능
- most_common() 이라는 메서드로 데이터의 개수가 많은 순으로 정렬된 배열 리턴 가능
```python
Counter('hello world').most_common()
>>> [('l', 3), ('o', 2), ('h', 1), ('e', 1), (' ', 1), ('w', 1), ('r', 1), ('d', 1)]


Counter('hello world').most_common(2)
>>>[('l', 3), ('o', 2)]
```
- 덧셈, 뺄셈에도 사용 가능
```python
counter1 = Counter(["A", "A", "B"])
counter2 = Counter(["A", "B", "B"])

counter1 + counter2
>>> Counter({'A': 3, 'B': 3})
```


### startswith / endswith
: 특정 문자열로 시작하는 것, 혹은 끝나는 것 찾을 때 유용
```python
str = 'final exam'

# startswith(특정 문자)
result = str.startswith('final')
print(result) # True

# endswith
result2 = str.endswith('exam')
print(result2) # False
```

### join()
: 매개변수로 들어온 리스트에 있는 요소 하나하나를 합쳐서 하나의 문자열로 바꾸어 반환하는 함수

- ```'구분자'.join(리스트)```

문자열만 join할 수 있음
```python
str = 'final exam'

# startswith(특정 문자)
nums = [1, 2, 3] 
print(''.join(nums)) # 불가능
print(''.join(map(str,nums))) # 가능
```

