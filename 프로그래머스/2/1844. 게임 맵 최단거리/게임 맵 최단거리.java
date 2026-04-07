import java.util.*;

class Solution {
    
    static boolean[][] visited;
    static int n,m;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        n = maps.length;    // 세로
        m = maps[0].length; // 가로
        
        visited = new boolean[n][m];
        bfs(0,0, maps);
        
        if(maps[n-1][m-1] == 1){
            return -1;
        } else{
             return maps[n-1][m-1];
        }
       
    }
    
    static public void bfs(int x, int y, int[][] maps){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y,x});
        visited[y][x] = true;
        
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int curX = now[1];
            int curY = now[0];
            
            for(int i=0; i<4;i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                
                if(nextX>=0 && nextX<m && nextY>=0 && nextY<n){
                    if(!visited[nextY][nextX] && maps[nextY][nextX] == 1){
                        visited[nextY][nextX] = true;
                        queue.add(new int[]{nextY, nextX});
                        maps[nextY][nextX] = maps[curY][curX] + 1;
                    }

                }
            }
        }
    }
}