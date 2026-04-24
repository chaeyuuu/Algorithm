import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        
        ArrayList<Integer> arrList = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++){
            if(arr[i] % divisor == 0){
                arrList.add(arr[i]);
            }
        }
        
        Collections.sort(arrList);
        
        
        int[] answer = new int[arrList.size()];
        if(arrList.size()!=0){
            for(int i=0; i<arrList.size(); i++){
                answer[i] = arrList.get(i);
            }
        } else {
            //answer = new int[1];
            answer = new int[]{-1};
        }
        
        
        
        return answer;
    }
}