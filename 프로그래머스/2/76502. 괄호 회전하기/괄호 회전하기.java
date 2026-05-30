import java.util.*;
import java.io.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int x = s.length();
        for(int i=0; i<x; i++) {
            // x만큼 진행하기
            Stack<Character> stack = new Stack<>();
            boolean isValid = true;
            
            for(int j=0; j<x; j++) {
                // 첫 시작 index 0 -> 다음 1 --> 그그그그 원형으로 나누기해서..
                // index 시작이 x가 되능거임 근데 스택의 길이만큼 봐야하니까..
                // stack이 안 비어있으면 ..
                // j는 하나의 스택 내에서 .. 
                char c = s.charAt((i + j) % x);
                
                if(c=='[' || c=='{' || c =='(') {
                    stack.push(c);
                } else {
                    if(stack.empty()){
                        // 비어있으면 ... 
                        isValid = false;
                        break;
                    } 
                     
                    if(c==']' && stack.peek() =='[' || c=='}' && stack.peek() =='{'|| c==')' && stack.peek() =='('){
                            stack.pop();
                        } else {
                            isValid = false;
                            break;
                        }

                    }
                    
                    
                
            }
            
            if(isValid && stack.isEmpty()) answer++;
                
        }
        
        
        return answer;
    }
}