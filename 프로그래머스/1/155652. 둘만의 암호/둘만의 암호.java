import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        
        // a~z 까지 담은 배열에서
        // skip에 들어있는거 삭제
        
        List<Character> list = new ArrayList<>();
        for (char i = 'a'; i <= 'z'; i++) {
            if(!skip.contains(String.valueOf(i))){
                list.add(i);
            }
        }
            
        // s에서 앞 글자부터 하나씩 index 만큼 더하기
        for(int i=0; i<s.length();i++){
            char cur = s.charAt(i);
            int currIdx = list.indexOf(cur);
            
            int nextIdx = (currIdx + index) % list.size();
            
            answer.append(list.get(nextIdx));
        }
        
        return answer.toString();
    }
}