def solution(participant, completion):
    participant.sort()
    completion.sort()
    
    for p, c in zip(participant, completion):
        if p != c:
            return p
    return participant[-1]

from collections import Counter
def solution(participant, completion):
    part_count = Counter(participant)
    comp_count = Counter(completion)
    
    for person in part_count:
        if part_count[person] != comp_count[person]:
            return person

