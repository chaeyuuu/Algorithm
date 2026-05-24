import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        
        int i=0;
        while(i<progresses.length){
            if(progresses[i] < 100) {
                int day = (100-progresses[i]) / speeds[i];
                if((100-progresses[i]) % speeds[i] != 0){
                    day += 1;
                }
            
                // 다른거 진행될 동안 진행된 날 수 만큼 다른 작업들도 진행이 되어야함 -> 반영하기
                for(int j=i; j<progresses.length; j++){
                    progresses[j] += (speeds[j] * day);
                }
            }
            
            int count = 0;
            while (i < progresses.length && progresses[i] >= 100) {
        count++;
        i++;
    }
    
    // 3. 이번에 한 번에 배포된 기능의 개수를 리스트에 저장
    list.add(count);
            
        }
        
        int[] answer = new int[list.size()];
        
        for(int a=0; a<list.size(); a++){
            answer[a] = list.get(a);
        }
        
        return answer;
    }
}