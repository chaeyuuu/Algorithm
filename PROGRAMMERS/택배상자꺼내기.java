class Solution {
    public int solution(int n, int w, int num) {
        // n: 총 택배 상자
        // w: 가로로 놓는 상자의 개수
        int count = 1;
        int answer = 0;
        int targetX = -1, targetY = -1;
        
        int h = 0;
        if (n%w==0){
            h = n/w;
        } else{
            h = n/w +1;
        }
        
        int[][] boxes = new int[h][w];
        
        for (int i=0; i<h; i++) {
            if (i%2==0){
                // 짝수 층이면 왼 -> 오
                for (int j=0; j<w; j++){
                   if (count <= n) boxes[i][j]= count++;
                }   
            } else {
                // 홀수: 오 -> 왼
            for(int j=w-1; j>=0;j--){
               if (count <= n) boxes[i][j] = count++;
                }
            }
        }
        
        // 이제 박스의 위치
        for (int i=0; i<h;i++){
            for (int j=0; j<w; j++){
                if(boxes[i][j] == num){
                    targetX = i;
                    targetY = j;
                    break;
                }
            }
        }
        
        // targetX 위에 몇 개나 더 있는지
        for(int i=targetX; i<h; i++){
            if(boxes[i][targetY]!=0) answer++;
        }
        
        return answer;
    }
}
