import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> people = new HashMap<>();
        
        for(int i=0; i<participant.length; i++){
            people.put(participant[i], people.getOrDefault(participant[i], 0)+1);
        }
        
        for(int i=0; i<completion.length;i++){
            if(people.containsKey(completion[i])){
                // 포함하고 있으면 값 하나 빼기
                people.put(completion[i], people.get(completion[i])-1);
                
            }
        }
        
        for(String person : people.keySet()){
            if(people.get(person) != 0)
                answer = person;
        }
        
        return answer;
    }
}