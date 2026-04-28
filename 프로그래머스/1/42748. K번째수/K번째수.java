import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        // 0부터 1(1-1)까지 자르고 정렬한다음에 2이 위치에 있는거 픽
        for(int i=0; i<commands.length; i++){
            ArrayList<Integer> arr = new ArrayList<>();
            for(int j=commands[i][0]-1; j<commands[i][1]; j++){
                arr.add(array[j]);
            }
            
            Collections.sort(arr);
            answer[i] = arr.get(commands[i][2]-1);
        }
        
        return answer;
    }
}