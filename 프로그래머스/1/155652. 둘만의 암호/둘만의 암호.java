import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        HashSet<Character> skipSet = new HashSet<>();
        for(int i=0; i<skip.length(); i++){
            skipSet.add(skip.charAt(i));
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++){
            int charIndex = s.charAt(i) - 'a';
            int shiftCount = 0;
            
            while(shiftCount < index){
                charIndex = (charIndex+1)% 26;
                
                char nextChar = (char) (charIndex + 'a');
                
                if(skipSet.contains(nextChar)){
                    continue;
                }
                
                shiftCount++;
                
            }
            
            sb.append((char)(charIndex +'a'));
            
        }
        
        
        return sb.toString();
    }
}