import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        
        ArrayList<Integer> arrList = new ArrayList<>();
        arrList.add(arr[0]);
        for(int i=1; i<arr.length;i++){
            int prev = arr[i-1];
            if(arr[i] != prev){
                arrList.add(arr[i]);
            }
        }
        
        
        int[] answer = new int[arrList.size()];
        for(int i=0; i<arrList.size();i++){
            answer[i] = arrList.get(i);
        }

        return answer;
    }
}