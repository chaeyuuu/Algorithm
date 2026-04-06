import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        // 세로, 가로로 해야댐
        
        int width = park[0].length();
        int height = park.length;
                
        int startX = 0;
        int startY = 0;
        
        char[][] parkMap = new char[height][width];
        for(int i=0; i<height;i++){
            for(int j=0; j<width;j++){
                parkMap[i][j] = park[i].charAt(j);
                System.out.println(parkMap[i][j]);
                
                if(parkMap[i][j] == 'S'){
                    startX = j;
                    startY = i;
                }
            }
        }        
        
        System.out.println(startX +","+ startY);
        
        // 2. routes 에서 이동할 수 있는지 확인부터
        // 동서남북 입력값 공백에 따라 .. 
        for(int i=0; i<routes.length;i++){
            String[] parts = routes[i].split(" ");
            String dest = parts[0];
            int len = Integer.parseInt(parts[1]);
            
            boolean isMove = true;
            
            // 범위도 안 넘고 장애물이 있는 칸을 지나가면 안됨
            if(dest.equals("E")){
                
                if(startX + len >= width) isMove = false;
                
                if(isMove){
                    for(int j = startX + 1; j <= startX + len; j++) {
                        if(parkMap[startY][j] == 'X') {
                        isMove = false;
                        break;
                        }
                    }
                }
                
                if(isMove) startX += len;

            } else if (dest.equals("W")){
                // 서
                if(startX - len < 0) isMove = false;
                if(isMove){
                    for(int j=startX - 1; j>=startX -len ;j--){
                        if(parkMap[startY][j] == 'X'){
                            isMove = false;
                            break;
                        }
                    }
                }
                
                if(isMove) startX -= len;
                
            } else if (dest.equals("S")) {
                // 남
                if(startY + len >= height) isMove = false;
                if(isMove){
                    for(int j=startY + 1; j<=startY + len ;j++){
                        if(parkMap[j][startX] == 'X'){
                            isMove = false;
                            break;
                        }
                    }
                }
                
                if(isMove) startY += len;
                
                
            } else if (dest.equals("N")) {
                // 북
                if(startY - len < 0) isMove = false;
                if(isMove){
                    for(int j=startY - 1; j>=startY-len ;j--){
                        if(parkMap[j][startX] == 'X'){
                            isMove = false;
                            break;
                        }
                    }
                }
                
                if(isMove) startY -= len;
                
            }
        }

        // 도착지점 인덱스 값 return        
        return new int[]{startY, startX};
    }
}