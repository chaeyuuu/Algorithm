def solution(participant, completion):
    answer = ''
    for person in participant:
        if person not in completion:
            return person