import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 큐에 얘네 작업완료되는데 필요한 날짜 계산
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<progresses.length; i++){
            int day = (int) Math.ceil((double)(100 - progresses[i]) / speeds[i]);
            queue.add(day);
        }
        
        List<Integer> results = new ArrayList<>();
        while(!queue.isEmpty()){
            int answer = 1;
            int currentDay = queue.poll();
            
            while (!queue.isEmpty() && queue.peek() <= currentDay) {
                queue.poll();
                answer++;
            } 
            
            results.add(answer);
        }
        
        return results.stream().mapToInt(i->i).toArray();
    }
}