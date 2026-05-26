class Solution {
    public int solution(int[][] signals) {
        int n = signals.length;
        
        int maxTime = 1;
        for(int i=0; i<n; i++){
            int c = signals[i][0] + signals[i][1] +signals[i][2];
            maxTime = lcm(maxTime, c);
        }
        
        for(int t =1; t<=maxTime ; t++){
            boolean isYellow = true;
            
            for(int i=0; i<n; i++){
                int g = signals[i][0];
                int y = signals[i][1];
                int r = signals[i][2];
                int c = g + y + r;
                
                int pos = t % c;
                
                if(!(pos >= g && pos < g+y)){
                    isYellow = false;
                    break;
                }
            }
            
            if (isYellow){
                return t+1;
            }
        }
        
        
        
        return -1;
    }
    
    // 최대 공약수
    private int gcd(int a, int b){
        while (b!=0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    
    private int lcm (int a, int b){
        return (a*b) / gcd(a, b);
    }
}