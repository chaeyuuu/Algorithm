import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String s) {
        // int[] answer = {};
        
        // 최종 목표는 '1' 을 만들기..
        int count = 0;
        
        // String binaryStr = "0";
        int zeroCount = 0;
        int oneCount = 0;
        int zeroSum =0;
        
        while (!s.equals("1")){
            zeroCount = 0;
            oneCount = 0;
            // boolean[] isDelete = new boolean[list.size()];
            
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '0'){
                    zeroCount++;
                } else{
                    oneCount++;
                }
            }
            
            // 0제거 후 길이 즉 1의 개수만큼 ..!! 그걸 이진수로 변환하는거임 ㅇㅇ
            s = Integer.toBinaryString(oneCount);

            
            
            // System.out.println(newList.size()); // 6
            // s = Integer.toBinaryString(newList.size());
            count++;
            zeroSum += zeroCount;

        }
    
        
        int[] answer = new int[2];
        answer = new int[]{count, zeroSum};

        
        return answer;
    }
}