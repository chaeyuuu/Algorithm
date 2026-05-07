class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {};
        
        int height = wallpaper.length;
        int width = wallpaper[0].length();
        
        int maxX = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        
        for(int y=0; y<height; y++){
            for(int x=0; x<width; x++){
                if(wallpaper[y].charAt(x) == ('#')){
                    maxX = Math.max(x, maxX);
                    minX = Math.min(x, minX);
                    maxY = Math.max(y, maxY);
                    minY = Math.min(y, minY);
                }
            }
        }
        
        answer = new int[]{minY, minX, maxY+1, maxX+1};
        
        return answer;
    }
}