import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++) {
            pq.add(scoville[i]);
        }
        
        // scovile에 있는 애들이 다 7 이상이 될때까지
        while(pq.peek()<K){
            
            if(pq.size() >= 2){
                pq.add(pq.poll() + pq.poll()*2);
                answer++;
            } else{
                return -1;
            }
            
        }
        
        return answer;
    }
}