import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());

        String line;
        int count = 0;
        HashMap<String, Integer> map = new HashMap<>();

        // 종별로 카운트
        while ((line = br.readLine()) != null) {
            count++;
            map.put(line, map.getOrDefault(line, 0) + 1);
        }

        // 정렬해야하니까 list로 변경
        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        // key마다 value를 count으로 나눠서 4째짜리까지 반올림해서 출력
        for (String key : keys) {
            int value = map.get(key);

            double percent = (double) value * 100 / count;
            System.out.println(key + " " + String.format("%.4f", percent));
        }
    }
}