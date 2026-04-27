class Solution {
    public int[] solution(int brown, int yellow) {
        
        
        // yellow의 약수 구하기
        int width = 0;
        int height = 0;
        for(int i=1; i<=Math.sqrt(yellow); i++){
            if(yellow % i==0){
                height = i;
                width = (yellow / i);
            }
            
            if(height*2 + width*2 + 4 == brown) break;
            
        }
        
        int[] answer = new int[2];
        width += 2;
        height +=2;
        
        answer[0] = width;
        answer[1] = height;
        
        return answer;
    }
}