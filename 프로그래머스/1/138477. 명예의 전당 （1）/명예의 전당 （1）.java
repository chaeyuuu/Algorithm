import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int k, int[] score) {
        // int[] answer = {};
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        int[] answer = new int[score.length];

        for(int i=0; i<score.length; i++){
            if(pQueue.size() < k){
                pQueue.add(score[i]);
            } else {
                // 가장 값 작은거랑 지금 score이랑 비교해서 더 큰 값 넣기
                int compare = pQueue.poll();
                if(compare < score[i]){
                    pQueue.add(score[i]);
                } else {
                    pQueue.add(compare);
                }
            }
            
            answer[i] = pQueue.peek();
        }
        
    
        
        return answer;
    }
}