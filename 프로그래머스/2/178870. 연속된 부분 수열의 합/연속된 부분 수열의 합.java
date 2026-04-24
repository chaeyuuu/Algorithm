class Solution {
    public int[] solution(int[] sequence, int k) {
        // 합이 k인 부분 수열이 여러 개인 경우 길이가 짧은 수열
        // 길이가 짧은 수열이 여러 개인 경우 앞쪽(시작 인덱스가 작은)에 나오는 수열
        int[] answer = new int[2];

        for(int i=0; i<sequence.length; i++){
            if(sequence[i]==k){
                answer = new int[]{i, i};
                return answer;
            }
        }
        
        int start = 0;
        // int end = sequence.length-1;
        int end = 0;
        int count = 0;
        
        int len = Integer.MAX_VALUE;
        int resultS = 0;
        int resultE = 0;
        
        for(end=0; end <sequence.length; end++) {
            count +=  sequence[end];
            
            while (count > k){
                count -= sequence[start];
                start ++;
            }
            
            if(count == k){
                if ((end-start+1) < len) {
                    resultS = start;
                    resultE = end;
                    len = end-start+1;
                    // count = sequence[start];                    
                }
            }
            
            
        }
        
        answer = new int[]{resultS, resultE};
        
        return answer;
    }
}