import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] words = s.toLowerCase().split("");
        
        boolean isFirst = true;
        
        for(int i=0; i<words.length;i++){
            if(isFirst){
                answer += words[i].toUpperCase();
            } else {
                answer += words[i];
            }
            
            if(words[i].equals(" ")){
                isFirst = true;
            } else {
                isFirst = false;
            }
        }
        
        
        
        
        return answer;
    }
}