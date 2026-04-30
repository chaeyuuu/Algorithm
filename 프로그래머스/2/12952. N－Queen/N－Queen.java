import java.util.*;

class Solution {
    // 
    int answer = 0;
    int[] dx = {1,1,0,-1,-1,-1,0,1,};
    int[] dy = {0,-1,-1,-1,0,1,1,1};
    
    
    public int solution(int n) {
        // 한 행에는 하나의 퀸만
        int[][] board = new int[n][n];
        backtracking(0, board, n);
        
        return answer;
    }
    
    public void backtracking(int y, int[][] board, int n){
        if(y==n) {
            answer++;
            return;
        }
        
        for(int x=0; x<n; x++){
            // queen을 놓을 수 있으면 1로 표시
            if(isSafe(board, x, y, n)){
                board[y][x] = 1;
                backtracking(y+1, board, n);
                board[y][x] = 0;
            }
        }
    }
    
    public boolean isSafe(int[][] board, int x, int y, int n){
        for(int i=0; i<8; i++){
            int nx = x;
            int ny = y;
            
            while(true){
                nx += dx[i];
                ny += dy[i];
                
                if(nx >=0 && nx < n && ny>=0 && ny<n){
                    if(board[ny][nx] == 1) return false;
                } else{
                    break;
                }
            }
        }
        
        return true;
    }
}