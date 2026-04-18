import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int k, int[] score) {
       
        ArrayList<Integer> results = new ArrayList<>(); // 명예의 전당
        ArrayList<Integer> arr = new ArrayList<>(); // 발표 점수
        
        for(int i=0; i<score.length; i++){
            
            if(results.size() == 0){
                // 디폴트값
                results.add(score[i]); // 명예의 전당에 추가
                arr.add(results.get(0)); // 발표 점수에 추가
                
            } else {
                // 명예의 전당 자리가 남아있으면
                if(results.size() < k){
                    results.add(score[i]);
                    Collections.sort(results);
                    arr.add(results.get(0));
                } else {
                    // 자리가 안 남아 있으면
                    // 들어오려는 값이 더 큰 경우
                    if(results.get(0) <= score[i]){
                        results.remove(0);
                        results.add(score[i]);
                        Collections.sort(results);
                        arr.add(results.get(0));
                    } else{
                        // 작은 경우
                        Collections.sort(results);
                        arr.add(results.get(0));
                    }
                }
            } 
            
        }
        
        int[] answer = new int[arr.size()];
        for(int i=0; i<arr.size(); i++){
            answer[i] = arr.get(i);
        }
        
        
        return answer;
    }
}