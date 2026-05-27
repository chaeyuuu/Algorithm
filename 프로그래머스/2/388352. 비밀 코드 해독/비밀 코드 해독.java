import java.util.*;
import java.io.*;

class Solution {
    
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        
        // n개에서 5개씩 조합만들어서 set에 넣기?!
        HashSet<List<Integer>> hashSet = new HashSet<>();
        makeCombination(1, 0, new ArrayList<>(), hashSet, n);
        
        // set 순회하면서 보는데
        // hashSet으로 중복 제거한 개수가 ans랑 다르면 바로 pass.. 
        // 만약에 중복 제거한 개수가 ans랑 같으면 해당 set은 가능한 것 !! result ++;
        
        HashSet<List<Integer>> tempSet = new HashSet<>(hashSet);
        
        // 하나의 hashSet을 비교할거임
        for(List<Integer> candidate : hashSet){
            // System.out.println(candidate);
            // 그 hashSet은 q[i] 모든 것과 ans[i]가 같아야 result로 추가될 수 있음
            boolean isAllMatch = true;
            
            // q를 하나씩 비교해보자능
            // 아 근데 나 위에 이 q를 compareSet으로 만들어놧음 !!
            for(int i=0; i<q.length; i++){
            // 그래서 .. 이 candidate 가 compareSet 하나씩이랑 개별적으로 해서 다 ans 개수 동일하면 증가 matchCount++;!!
                
                HashSet<Integer> compareSet = new HashSet<>();
                for(int num: q[i]){
                    compareSet.add(num);
                }
            
                int matchCount = 0;
                
                // list내 각 숫자가 compareSet에 있는지 확인해보기
                for(int num : candidate){
                    if(compareSet.contains(num)){
                        matchCount ++ ;
                    }
                }
            
                if(matchCount != ans[i]) {
                // 만약에 match 개수 안 맞으면!!
                    isAllMatch = false;
                    break;
                }
                
            }
            
            if(isAllMatch) answer++;
        
        }
        return answer;
    }
    
    void makeCombination(int start, int count, List<Integer> curr, HashSet<List<Integer>> set, int n){
        if(count == 5){
            set.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i=start; i<=n ; i++){
            curr.add(i);
            
            makeCombination(i+1, count+1, curr, set, n);
            
            curr.remove(curr.size() - 1);
        }
        
    }
}