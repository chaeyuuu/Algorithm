
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 1)+1);
        }
        
        for(int key: map.keySet()){
            System.out.println(key);
            answer+=1;
        }
        
        answer = Math.min(answer, nums.length/2);
        
        
        return answer;
    }
}