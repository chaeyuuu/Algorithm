import java.util.*;
import java.io.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        // 가장 큰 수를 문자열로 바꿔서 출력하면댐
        // 문자열로 바꾸면 자동으로 정렬? 됨
        
        String[] strNums = new String[numbers.length];
        
        
        for(int i=0; i<numbers.length; i++){
            strNums[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(strNums, (s1, s2)->{
            // 내림 차순 정렬
            return (s2+s1).compareTo(s1+s2);
        });
        
        if(strNums[0].equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        for(String s:strNums){
            sb.append(s);
        }
        
        return sb.toString();
    }
}