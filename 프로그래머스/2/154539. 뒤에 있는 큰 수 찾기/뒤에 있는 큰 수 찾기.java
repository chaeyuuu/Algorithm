import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        // 스택에 들어오는 수가 현재 스택의 최상단의 값보다 크면 걔가 값이 됨
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i=1; i<numbers.length; i++){
            // 스택이 비어있지 않고 현재 스택의 최상단의 값이 들어오는 값보다 크다면
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]){
                int num = stack.pop();
                answer[num] = numbers[i];
            }
            
            stack.push(i); // 인덱스를 저장

        }
                    
           while(!stack.isEmpty()){
                // 다 돌았는데 스택이 비어있지 않다면
                answer[stack.pop()] = -1;
            }
        
    
        return answer;
    }
}