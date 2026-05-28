import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        // 내림차순 정렬
        // 맨 앞에꺼 뽑고
        // 뒤에서부터 더하기 !!
        
        Arrays.sort(people);
        
        // 앞에서 오고~~ 뒤에서 오고
        int start = 0;
        
        int length = people.length;
        int end =length-1;
        
        while(start <= end){
            
            if(people[start] + people[end] <= limit) {
                if(start < end){
                    start++;
                    end--;
                    answer++;
                } else {
                    answer++;
                    break;
                }
                
            } else {
                // 그냥 혼자 타시긩 .. 
                 if(start < end){
                    end--;
                    answer++;
                } else {
                     answer++;
                     break;
                 }
                
            }
        }

        return answer;
    }
}