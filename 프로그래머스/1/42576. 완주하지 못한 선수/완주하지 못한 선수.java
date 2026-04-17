import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        // participant에는 있는데 completion에는 없는 사람
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<participant.length; i++){
            map.put(participant[i], map.getOrDefault(participant[i], 0)+1);
        }
   
        
        for(String comple : completion){
            // completion 돌면서 hashmap에 있는지 확인
            if(map.containsKey(comple)){
                map.put(comple, map.get(comple)-1);
            }
        }
        
        for(String key: map.keySet()){
            if(map.get(key) != 0){
                answer = key;
            }
        }
        
    return answer;
    }
}