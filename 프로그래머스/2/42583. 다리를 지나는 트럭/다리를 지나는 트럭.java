import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<truck_weights.length; i++){
            queue.add(truck_weights[i]);
        }
        
        // 다리를 지나고 있는 트럭
        Queue<Integer> move = new LinkedList<>();
        for(int i=0; i<bridge_length; i++){
            move.add(0);
        }
        
        // 대기 트럭이 남아있지 않는 동안
        int currentWeight = 0;
        int totalSec = bridge_length;
            
        // 지금 다리 위에 올라가있는 무게랑 대기 맨 앞에 있는 트럭 더했을때
        // 다리 위에 올라올 수 있는지
        while(!queue.isEmpty()){
            totalSec++;
                
            // 1초마다 나가는 애들은 나감
            int exit = move.poll();
            currentWeight-= exit;
                
            if(!queue.isEmpty() && currentWeight + queue.peek() <= weight){
                // 다리에 올라올 수 있으면
                // 대기 트럭에 있는 애 추가하기
                int now = queue.poll();
                move.add(now);
                currentWeight += now;
            } else {
                // 무게 초과면 그냥 0 추가
                move.add(0);
            }
        }
        
        
        
        return totalSec;
    }
}