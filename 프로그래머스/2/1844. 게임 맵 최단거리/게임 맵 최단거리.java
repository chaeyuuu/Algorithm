import java.util.*;

class Solution {
    
    boolean[][] visited;
    int dx[] = {1,0,-1,0};
    int dy[] = {0,-1,0,1};
    int height;
    int width;
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        height = maps.length;
        width = maps[0].length;
        visited = new boolean[height][width];

        bfs(0,0, maps);
        
        int dest = maps[height-1][width-1];
        
        if(dest == 1){
            return -1;
        }

        return dest;
    }
    
    public void bfs(int y, int x, int[][] maps){
        Queue<int[]> queue = new LinkedList<>();
        visited[y][x] = true;
        queue.add(new int[]{y,x});
        
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int curX = now[1];
            int curY = now[0];
            
            for(int i=0; i<4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                
                if(nx>=0 && ny>=0 && nx<width && ny<height){
                    if(!visited[ny][nx] && maps[ny][nx]==1){
                        visited[ny][nx] = true;
                        queue.add(new int[]{ny, nx});
                        maps[ny][nx] = maps[curY][curX] + 1;
                    }
                }
            }
            
        }
    }
}