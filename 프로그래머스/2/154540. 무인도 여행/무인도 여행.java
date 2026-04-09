import java.util.*;



class Solution {
    
    
    static boolean[][] visited;
    static int height;
    static int width;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    static int count;
    static int[] answer;
    
    public int[] solution(String[] maps) {
        
        ArrayList<Integer> arr = new ArrayList<>();
        height = maps.length;
        width = maps[0].length();
        visited = new boolean[height][width]; //4x5(세로x가로)
        
        for(int i=0; i<height; i++){
            for(int j=0; j<maps[i].length();j++){
                // 아직 방문 안 했고 x가 아니라면
                // System.out.println(maps[i].charAt(j));
                if(!visited[i][j] && maps[i].charAt(j) != 'X'){
                    arr.add(bfs(j, i, maps));
                    // arr.add(count);
                }
                
            }
        }
        
        if(arr.size()>0){
            answer = new int[arr.size()];
        } else {
            answer = new int[1];
        }
        
        
        for(int i=0; i< arr.size();i++){
            answer[i] = arr.get(i);
        }
        
        Arrays.sort(answer);
        
        if (arr.size()!=0){
            return answer;
        } else {
            answer[0] = -1;
            return answer;
        }
        
    }
    
    public int bfs(int x, int y, String[] maps){
        count = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y,x});
        visited[y][x] = true;
        
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int curX = now[1];
            int curY = now[0];
            
            // System.out.println( "cur: "+curX +"," +curY);
             count +=  maps[curY].charAt(curX) - '0';
            // System.out.println("count: "+ count);
            
            for(int i=0; i<4; i++){
                int nextX = dx[i] + curX;
                int nextY = dy[i] + curY;
                
                // System.out.println( "next: "+nextX +"," +nextY);
                
                // 범위 안이고, 방문하지 않았고, X가 아니라면
                if(nextX >=0 && nextY >=0 && nextX <width && nextY < height){
                    if(!visited[nextY][nextX] && maps[nextY].charAt(nextX) != 'X'){
                        visited[nextY][nextX] = true;
                        queue.add(new int[]{nextY, nextX});
                        // System.out.println("maps: "+maps[curY].charAt(curX));
                        
                        // count += maps[curY].charAt(curX);
                        //count += maps[nextY].charAt(nextX);
                        //System.out.println(count);
                    }
                }
                
               
                
            }
            
        }
        
        return count;
    }
}