import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        // 공평하게 안 나눠지면 0 return
        HashMap<Integer, Integer> right = new HashMap<>();
        HashSet<Integer> left = new HashSet<>();
        
        // 처음에는 다 오른쪽에 있음
        for(int i=0; i<topping.length; i++){
            right.put(topping[i], right.getOrDefault(topping[i],0)+1);
        }
        
        for(int i=0; i<topping.length; i++){
            // 하나씩 왼쪽으로 옮김
            int move = topping[i];
            left.add(move);
            
            if(right.get(move) == 1){
                right.remove(move);
            } else {
                right.put(move, right.get(move)-1);
            }
            
            // 옮기고 나서 비교
            if(left.size() == right.size()){
                answer++;
            }
            
        }
        
        
        
        for(int i=1; i<topping.length; i++){
            // i를 기준으로 topping 배열 나누기
        }
        
        
        return answer;
    }
}