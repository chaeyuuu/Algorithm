import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        // 길이는 최소 1~ 최대 elements.length
        // System.out.println(elements.length);
        
        // 길이가 1이면 중복 없이 .. 해야하고
        // 길이가 2이상인거부터
        // 1 1 4 7 9 
        // 근데 원형이라
        
        HashSet<Integer> hashSet = new HashSet<>();
        
        // 길이
        for(int i=1; i<=elements.length; i++){
            // 길이가 1부터 elements.length까지임
            // index가 0 부터 .. elements.length % ... 어쩌고로 해야 원형인데
            
            // 수열의 시작 위치
            for (int start = 0; start < elements.length; start++) {
                int sum = 0;
                
                
                for(int j=0; j < i; j++){
                    int curIndex = (start + j) % elements.length;
                    sum += elements[curIndex];
                }
            
                hashSet.add(sum);
            }
        }
        
        return hashSet.size();
    }
}