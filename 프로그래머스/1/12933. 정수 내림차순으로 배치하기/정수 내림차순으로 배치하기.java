import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        String[] str = String.valueOf(n).split("");
        Arrays.sort(str, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(String s : str){
            sb.append(s);
        }
        
        return Long.parseLong(sb.toString());
    }
}