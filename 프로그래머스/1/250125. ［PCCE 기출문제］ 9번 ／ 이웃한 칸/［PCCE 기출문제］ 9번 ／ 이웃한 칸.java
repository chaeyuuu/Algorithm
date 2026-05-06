import java.util.*;

class Solution {
    
    int[] dw = {1,0,-1,0};
    int[] dh = {0,-1,0,1};
    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        int n = board.length;
        
        for(int i=0; i<4; i++) {
            int curW = w + dw[i];
            int curH = h + dh[i];
            
            if(curW >= 0 && curW < n && curH >= 0 && curH < n){
                if(board[h][w].equals(board[curH][curW])){
                    answer+=1;
                }
            }
        }
        
        
        
        return answer;
    }
}