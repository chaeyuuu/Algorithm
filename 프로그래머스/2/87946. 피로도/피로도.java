import java.util.*;
import java.io.*;

class Solution {
    
    boolean[] isVisited;
    int maxDepth = 0;
    
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        isVisited = new boolean[dungeons.length];

        answer = dfs(k, 0, dungeons);
        
        
        return answer;
    }
    
    public int dfs(int k, int depth, int[][] dungeons){
        
        maxDepth = Math.max(depth, maxDepth);
        
        
        // 하나씩 돌면서
        for(int i=0; i<dungeons.length; i++) {
            // 남은 피로도가 최소 피로도보다 높으면
            if(!isVisited[i] && k >= dungeons[i][0]){
                isVisited[i] = true;
                dfs(k-dungeons[i][1], depth+1, dungeons);
                
                isVisited[i] = false;
            }
        }
        
        return maxDepth;
    }
}