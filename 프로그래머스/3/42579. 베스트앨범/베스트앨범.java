import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        // 일단 장르별로 plays 수 합산
        
        HashMap<String, Integer> genresMap = new HashMap<>();
        HashMap<String, List<Integer>> playsMap = new HashMap();
        for(int i=0; i<genres.length; i++){
            genresMap.put(genres[i], genresMap.getOrDefault(genres[i], 0)+plays[i]);
            
            playsMap.computeIfAbsent(genres[i], k ->
                                    new ArrayList<>()).add(i);
        }
        
       // System.out.println(genresMap);
        
        List<String> genreOrder = new ArrayList<>(genresMap.keySet());
        
        // 재생수 genresMap의 value 값 내림차순
        genreOrder.sort((o1, o2)-> genresMap.get(o2) - 
                      genresMap.get(o1));
        
       // System.out.println(genreOrder);
        
        // genreOrder는 이제 내림차순된 genres!! 그러면 .. 
        // 내가 playsMap 여기다가 인덱스를 담아놨움 .. 
        ArrayList<Integer> result = new ArrayList<>();
        for(String genre: genreOrder){
            
            // 해당하는 index를 꺼내온거니까
            List<Integer> playList = playsMap.get(genre);
            
            // 그 장르 내에서 많이 재생된 노래
            playList.sort((o1, o2) ->
                         plays[o2] - plays[o1]);
            
            for(int i=0; i<Math.min(playList.size(), 2); i++){
                result.add(playList.get(i));
            }
            
        }
        
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}