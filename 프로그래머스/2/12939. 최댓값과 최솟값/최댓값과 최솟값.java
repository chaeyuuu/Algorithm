import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] words = s.split(" ");
        // 정수로 변환
        int[] w = new int[words.length];
        
        for(int i=0; i<words.length;i++){
            w[i] = Integer.parseInt(words[i]);
        }
        
        Arrays.sort(w);
        
        // 최소값 최댓값
        int max = w[words.length-1];
        int min = w[0];
    
        answer = min + " " + max;
        
        return answer;
    }
}