import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        // 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
        // 만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 
        
        // N은 스테이지 수
        // stages는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열
        // 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지
        
        // 1. stages 훑으면서 ..
        // 2중 포문?!

        double[][] stageInfo = new double[N+1][2];
        int users = stages.length;
        
        System.out.println(users);
        
        for(int i=0; i<N; i++) {
            int failNum = 0;
            
            for(int j=0; j<stages.length; j++){
                if(stages[j] == i+1){
                    failNum ++;
                }
            }
            
            // System.out.println(failNum);
            
            
            if(failNum != 0){ 
                double failRate = (double) failNum / users;
            

                stageInfo[i][0] = failRate;
                stageInfo[i][1] = i+1;
                users -= failNum;
                // System.out.println(arr[i]);
            } else{
                stageInfo[i][0] = 0;
                stageInfo[i][1] = i+1;
            }
        }
        
        Arrays.sort(stageInfo, (o1, o2) ->{
            if(o1==o2){
                return Double.compare(o1[1], o2[1]);
            }
            
            return Double.compare(o2[0], o1[0]);
        });
        
        
        int[] answer = new int[N];
        for(int i=0; i<N; i++){
            answer[i] = (int) stageInfo[i][1];
        }
        
        
        return answer;
    }
}