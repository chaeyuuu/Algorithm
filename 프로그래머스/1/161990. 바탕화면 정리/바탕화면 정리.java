class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {};
        int height = wallpaper.length;
        int width = wallpaper[0].length();
        
        char[][] arr = new char[height][width];
        for(int i=0; i<height; i++){
            String line = wallpaper[i];
            for(int j=0; j<width; j++){
                arr[i][j] = line.charAt(j);
            }
        }
        
        int lux = 50;
        int luy = 50;
        int rdx = 0;
        int rdy = 0;
        
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                if(arr[i][j] == ('#')){
                    // System.out.println("i: "+i+" j:"+j);
                    lux = Math.min(lux, i);
                    luy = Math.min(luy, j);
                    rdx = Math.max(rdx, i);
                    rdy = Math.max(rdy, j);
                }
            }
        }
        
        answer = new int[]{lux, luy, (rdx+1), (rdy+1)};
        
        return answer;
    }
}