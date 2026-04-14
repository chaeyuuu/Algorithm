import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        line = line.toUpperCase();
        char[] word = new char[line.length()];
        for (int i = 0; i < line.length(); i++) {
            word[i] = line.charAt(i);
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < line.length(); i++) {
            map.put(word[i], map.getOrDefault(word[i], 0) + 1);
        }

        // key, value
        List<Map.Entry<Character, Integer>> entryList = new LinkedList<>(map.entrySet());
        Collections.sort(entryList, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        // map에서 가장 횟수가 많은 알파벳 출력
        if (entryList.size() > 1) {
            if (entryList.get(0).getValue().equals(entryList.get(1).getValue())) {
                System.out.println("?");

            } else {
                System.out.println(entryList.get(0).getKey());

            }
        } else {
            System.out.println(entryList.get(0).getKey());
        }
    }

}
