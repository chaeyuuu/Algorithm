import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        ArrayList<Integer> dayArr = new ArrayList<>();
        
        // 앞에 있는 기능이 배포되지 않으면 뒤에 있는건 마무리가 되어도 배포가 불가능함
        
        // 앞에 있는 기능 100이 될때 그 일자만큼
        // 다른 프로세스들도 진행이 되어있음 > 추가해줘야함
        boolean[] isPassed = new boolean[progresses.length];
        for(int i=0; i<progresses.length; i++){
            int day = 0;
            
            if(isPassed[i]) continue;
            
            // 첫 번째 프로세스의 최소 일자
            if((100 - progresses[i]) % speeds[i] != 0){
                 day = (100 - progresses[i]) / speeds[i] + 1;
            } else {
                 day = (100 - progresses[i]) / speeds[i];
            }                
            
            int answer = 0;
            for(int j=i; j<progresses.length; j++) {
                
                if(isPassed[j]) continue;
                                
                if(progresses[j] + speeds[j] * day >=100){
                    isPassed[j] = true;
                    answer++;
                } else {
                    break;
                }
            }
            
            dayArr.add(answer);
        }
        
        int[] results = new int[dayArr.size()];
        for(int i=0; i<dayArr.size(); i++){
            results[i] = dayArr.get(i);
        }
        
        
        return results;
    }
}