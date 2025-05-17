def solution(genres, plays):
    answer = []
    album = {}
    # (장르, [(곡번호, 재생수), ...], ... )
    plays_q = list(enumerate(plays))
        
    # print(plays_q)
    for genre,play in zip(genres,plays_q):
        # print(genre, play)
        if genre not in album:
            album[genre] = []
        album[genre].append(play)
    
    # dic은 sort 사용 불가, sorted 사용해야함
    # 장르별 총 재생 수로 정렬
    # x[0] 이 장르, x[1]이 (곡번호, 재생수)
    sorted_album = sorted(album.items(), key=lambda x: sum(count for index, count in x[1]), reverse=True)
    print(sorted_album)
    
    # 그 안에서 많이 재생된거 2개 -> 재생횟수 같으면 고유 번호 낮은거부터
    for genre, song in sorted_album:
        sorted_song = sorted(song, key=lambda x: (-x[1], x[0]))
        print(sorted_song)
        for i in range(min(2, len(song))):
            answer.append(sorted_song[i][0])
    # print(sorted_song)
    
    return answer