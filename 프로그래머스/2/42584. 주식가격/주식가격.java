import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        
        // 스택에 초를 저장
        Stack<Integer> stack = new Stack<>();
        int[] results = new int[prices.length];
        
        stack.push(0); // 초기값 넣기
        
        for(int i=1; i<prices.length; i++){
            // 인덱스를 저장..?!
            // 다음에 들어오려는게 지금 맨 상단에 있는거보다 작으면 
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                results[stack.peek()] = i - stack.peek();
                stack.pop(); // 상단에 있는거 없애기
                
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            results[stack.peek()] = prices.length - stack.peek()-1;
            stack.pop();
        }
        
        return results;
    }
}