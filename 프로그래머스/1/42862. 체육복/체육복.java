import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int defaultNum = n - lost.length;
        
        // 내가 아니면 앞 번호 친구에게 빌려줄 사람이 없으니까 !!
        // 뒤에 있는 애는 다른 애에게 또 기회가 있음
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                
                if(reserve[j] == lost[i]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    defaultNum++;
                    break;
                }
            }
        }
          
        for(int i=0; i<lost.length; i++) {
            if (lost[i] == -1) continue;
            for(int j=0; j<reserve.length; j++){
                
                
                if (reserve[j] == -1) continue;
                
                if(reserve[j] -1 == lost[i] || reserve[j] + 1 == lost[i]) {
                    defaultNum++;
                    reserve[j] = -1;
                    break;
                } else{
                    continue;
                }
                
            }
        }
        
        
        
        return defaultNum;
    }
}