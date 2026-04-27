import java.util.*;

class Solution {
    
    // 중복되는 숫자 없게 set으로
    Set<Integer> numberSet = new HashSet<>();
    
    public int solution(String numbers) {
        // 소수: 본인가 1만
        int answer = 0;
        
        // 모든 조합 만들기
        recursive("", numbers);
        
        // 소수인지 판별하기
        for(int num : numberSet){
            if(isPrime(num)) answer++;
        }
        
        return answer;
    }
    
    // 숫자 조합
    public void recursive(String comb, String others) {
        // 현재 조합이 비어있지 않다면 숫자로 변환해 Set에 추가
        if(!comb.equals("")){
            numberSet.add(Integer.parseInt(comb));
        }
        
        // 남은 숫자들 중에서 하나씩 골라 새로운 조합 생성
        for (int i = 0; i < others.length(); i++) {
            // 내 앞이랑 내 뒤 조합하기
            recursive(comb + others.charAt(i), 
                      others.substring(0, i) + others.substring(i + 1));
        }
    }
    
    // 소수 판별
    public boolean isPrime(int num){
        if(num < 2) return false;
        
        for(int i=2; i<=Math.sqrt(num); i++){
            // 중간에 0으로 나눠지는게 있으면 소수 아님
            if(num % i==0) return false;
        }
        
        return true;
    }
}