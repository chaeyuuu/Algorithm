import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        int extId = -1;
        switch(ext){
            case "code": extId = 0; break;
            case "date": extId = 1; break;
            case "maximum" :extId = 2; break;
            case "remain": extId = 3; break;
        }
        
        int sortIdx = -1;
        switch(sort_by){
            case "code": sortIdx = 0; break;
            case "date": sortIdx = 1; break;
            case "maximum" :sortIdx = 2; break;
            case "remain": sortIdx = 3; break;
        }
        
        ArrayList<int[]> list = new ArrayList<>();
        for(int[] row: data){
            if(row[extId] < val_ext){
                list.add(row);
            }
        }
        
        final int finalSortIdx = sortIdx; 

        
        Collections.sort(list, (o1, o2) ->
                        o1[finalSortIdx] - o2[finalSortIdx]);
        
        int[][] answer = new int[list.size()][4];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}