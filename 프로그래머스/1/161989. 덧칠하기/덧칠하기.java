class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int lastPoint = 0;
        
        // boolean[] paint = new boolean[n+1];
        int start = section[0];
        int len = section.length;
        for(int i=0; i<len; i++){
           
            // 아직 안 칠해진 부분이라면
            if(section[i]>lastPoint){
                 answer +=1;
                
                lastPoint = section[i]+m-1;
            }

           
        
        }
        
        
        return answer;
    }
}