import java.util.*;
import java.io.*;

class Solution {
    
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    static boolean[][] toMove;
    
    static int width;
    static int height;
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;    
        
        width = storage[0].length();
        height = storage.length;
        int origin = width * height;
        
        char[][] storages = new char[height][width];
        for(int i=0; i<height; i++){
            String line = storage[i];
            for(int j=0; j<line.length(); j++){
                storages[i][j] = line.charAt(j);
            }
        }
        
        for(int i=0; i<requests.length; i++) {
            toMove = new boolean[height][width];
            char nowAlphabet = requests[i].charAt(0);
            
            // 1. 지게차 요청 처리
            if(requests[i].length() == 1) {
                Queue<int[]> queue = new LinkedList<>();
                
                for(int y=0; y<height; y++) {
                    for(int x=0; x<width; x++){
                        if(y==0 || x==0 || y == height-1 || x == width-1){
                            if(storages[y][x] == nowAlphabet){
                                toMove[y][x] = true;
                            } else if (storages[y][x] == '0'){
                                queue.add(new int[]{y,x});
                                toMove[y][x] = true;
                            }
                        }   
                    }
                }
                
               
                while(!queue.isEmpty()){
                    int[] now = queue.poll();
                    int nowX = now[1];
                    int nowY = now[0];
                    
                    for(int d=0; d<4; d++){
                        int nextX = nowX + dx[d];
                        int nextY = nowY + dy[d];
                        
                        if(nextX >= 0 && nextY >= 0 && nextX < width && nextY < height && !toMove[nextY][nextX]){
                            if(storages[nextY][nextX] == '0'){
                                toMove[nextY][nextX] = true;
                                queue.add(new int[]{nextY, nextX});
                            } else if(storages[nextY][nextX] == nowAlphabet){
                                toMove[nextY][nextX] = true;
                            }
                        }
                    }
                }
                
                for(int y=0; y<height; y++){
                    for(int x=0; x<width; x++){
                        if (toMove[y][x]){
                            storages[y][x] ='0';
                        }
                    }
                }
            
            // 크레인
            } else {
                for(int y=0; y<height; y++){
                    for(int x=0; x<width; x++){
                        if(storages[y][x] == nowAlphabet){
                            storages[y][x] = '0';
                        }
                    }
                }
            }
        }
        
        int count = 0;
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                if(storages[i][j] != '0') count++;
            }
        }
        
        return count;
    }
}