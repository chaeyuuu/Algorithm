class Solution {
    public int solution(int n) {
        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = i;
        }
        
        int end = 1;
        int sum = 1;
        int start = 1;
        int count = 1;
        
        while(end!=n){
            if(sum==n){
                count++;
                end++;
                sum += arr[end];
                
            } else if (sum < n){
                end++;
                sum += arr[end];
                
            } else if (sum > n){
                
                sum -= arr[start];
                start++;
                
            }
        }
        
        return count;
    }
}