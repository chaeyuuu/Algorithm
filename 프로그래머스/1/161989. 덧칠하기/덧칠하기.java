import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        // 칠해진 범위의 끝
        int lastPoint = 0;
        
        int len = section.length;
        for(int i=0; i<len; i++){
           
            // 현재 위치가 칠해진 범위가 아니라면
            if(section[i] > lastPoint){
                answer++;
                lastPoint = section[i] + m - 1;
            }
            
        }
        
        
        return answer;
    }
}