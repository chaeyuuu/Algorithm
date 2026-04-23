import java.util.*;
import java.io.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int answer = 0;
        
        // 스포방지 단어면 중요한 단어
        // 메세지의 스포방지 구간(spoiler_ranges)이 아닌 구간에 등장한 적 없어야함
        // 이전에 공개된 스포방지 단어에 없어야함
        
        // 문장에 있는 모든 단어를 공백 기준으로 분리해서 저장하기
        Set<String> safeWords = new HashSet<>();
        
        String[] s = message.split(" ");
        
        int[] start = new int[s.length];
        int cur = 0;
        for(int i=0; i<s.length; i++){
            start[i] = cur;
            cur += s[i].length() + 1;
        }
        
        // 스포일러 방지 구간에 포함되지 않는 단어들을 저장
         for (int i = 0; i < s.length; i++) {
            int wStart = start[i];
            int wEnd = start[i] + s[i].length() - 1;
             
             boolean isSpoiler = false;
             for(int[] range: spoiler_ranges){
                 if(wStart <= range[1] && wEnd >= range[0]){
                     isSpoiler = true;
                     break;
                 }
             }
             
             // 스포일러 방지 구간에 해당하지 않는 단어들 저장
             if(!isSpoiler) safeWords.add(s[i]);
         }
        
        // System.out.println(safeWords);
        

         Set<String> spoilerWords = new HashSet<>();
        // 스포일러 구간에 있는 단어가 safeWords에 있는 단어인지 확인
        for (int i = 0; i < s.length; i++) {
            int wStart = start[i];
            int wEnd = start[i] + s[i].length() - 1;
             
             boolean isSpoiler = false;
             for(int[] range: spoiler_ranges){
                 if(wStart <= range[1] && wEnd >= range[0]){
                     isSpoiler = true;
                     break;
                 }
             }
             
             // 스포일러에 해당하는 단어면
            // safeWords에 있는 단어인지 확인
             if(isSpoiler){
                if(safeWords.contains(s[i]) || spoilerWords.contains(s[i])){
                    continue;
                } else {
                    spoilerWords.add(s[i]);
                    answer++;
                }
             }
         }
                
        return answer;
    }
}