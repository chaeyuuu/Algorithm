import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<numbers.length-1; i++){
            for(int j=i+1; j<numbers.length;j++){
                // System.out.println("i: "+i+" j: "+j);
                set.add(numbers[i]+numbers[j]);
            }
            // System.out.println(set);
        }
        
        answer = set.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        
        Arrays.sort(answer);

        return answer;
    }
}