import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        
        int num = photo.length;
        // System.out.println(num);
        int[] answer = {};
        answer = new int[num];
        
        for(int i=0; i<photo.length;i++){
            int count =0;
            // System.out.println(photo[i].length);
            for(int j=0; j<photo[i].length;j++){
               // photo에 있는 사람이 name에 있는지
                // name에 있으면 해당 name의 인덱스를 yearning[인덱스]
                // count += yearning[인덱스]
                
                // photo에 있는게 name에 있는지 봐야함
                for(int k=0; k<name.length;k++){
                    if(photo[i][j].equals(name[k])){
                        answer[i] += yearning[k];
                        System.out.println(count);
                    }
                }
            }
    
            
        }
        
        
        return answer;
    }
}