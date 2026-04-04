import java.util.*;

class Solution {
    public int solution(String[][] clothes) {

        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            if (!map.containsKey(clothes[i][1]))
                map.put(clothes[i][1], new ArrayList<>());
            map.get(clothes[i][1]).add(clothes[i][0]);
        }

        int result = 1;
        for (String key : map.keySet()) {
            result *= (map.get(key).size() + 1);
        }

        return result - 1;
    }
}