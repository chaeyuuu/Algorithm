import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> answerList = new ArrayList<>();
       
        for(int i=0; i<arr.length;i++){
            if(arr[i] % divisor == 0){
                answerList.add(arr[i]);
            }
        }
        Collections.sort(answerList);
         int[] answer = {};
        if(answerList.size()==0){
            answer = new int[]{-1};
        } else {
            answer = new int[answerList.size()];
            for(int i=0; i<answerList.size(); i++){
                answer[i] = answerList.get(i);
            }
        }
        return answer;
    }
}