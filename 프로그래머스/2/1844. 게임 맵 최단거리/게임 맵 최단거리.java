import java.util.*;

class Solution {
    
    int[] dx = {1,0,-1,0};
    int[] dy = {0,-1,0,1};
    boolean[][] visited;
    int n, m;
    
    public int solution(int[][] maps) {
        // 0인 곳은 못감
        // 1인 곳은 감
        // 만약에 n,n 의 값이 끝까지 1? 이면 최종적으로 -1 return
        
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        
        bfs(0,0, maps);
        
        if(maps[n-1][m-1] == 1){
            return -1;
        } else {
            return maps[n-1][m-1];
        }
        
    }
    
    public void bfs(int y, int x, int[][] maps){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y,x});
        visited[y][x] = true;
        
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int curY = now[0];
            int curX = now[1];
            
            for(int i=0; i<4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                
                if(nextX >= 0 && nextX < m && nextY < n && nextY >= 0){
                    if(maps[nextY][nextX] == 1 && !visited[nextY][nextX]){
                        visited[nextY][nextX] = true;
                        queue.add(new int[]{nextY, nextX});
                        maps[nextY][nextX] = maps[curY][curX] + 1;
                    }
                }
            }
            
        }
    }
    
}