import java.util.*;

class Solution {
    
    boolean[] visited;
    int maxCount;
    
    public int solution(int k, int[][] dungeons) {
        maxCount = 0;
        visited = new boolean[dungeons.length];
        
        dfs(k, dungeons, 0);
        
        return maxCount;
    }
    
    public void dfs(int k, int[][] dungeons, int count){
        
        maxCount = Math.max(maxCount, count);
        
        for(int i=0; i<dungeons.length; i++){
            // 최소 필요도보다높으면 
            if(dungeons[i][0]<=k && !visited[i]){
                visited[i] = true;
                dfs(k-dungeons[i][1], dungeons, count+1);
                visited[i] = false;
            }
        }
        
    }
}