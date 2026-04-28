import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        // 우선순위가 높은 프로세스
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int priority : priorities){
            pq.add(priority);
        }
        
        while(!pq.isEmpty()){
            for(int i=0; i<priorities.length; i++){
                // 기존 큐 순서대로 하기
                
                // 가장 큰 우선순위랑 지금 값이랑 같은지
                if(pq.peek() == priorities[i]){
                    answer++;
                    
                    // 지금 찾는 위치가 아니면
                    if(i == location){
                        return answer;
                    }
                
                    pq.poll();
                }
             }
        }
  
        return answer;
    }
}