package 구현;

import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

// 자주 나오는 단어 맨앞
// 단어 길이 길수록 앞
// 알파벳 앞쪽일수록 앞

public class boj20920 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (hashMap.containsKey(word)) {
                hashMap.put(word, hashMap.get(word) + 1);
            } else {
                hashMap.put(word, 1);
            }
        }

        List<String> keySet = new ArrayList<>(hashMap.keySet());

        keySet = keySet.stream()
                .filter(word -> word.length() >= M)
                .collect(Collectors.toList());

        // 알파벳 순
        Collections.sort(keySet);

        // 단어 길이가 길수록 앞에 배치
        Collections.sort(keySet, (String a, String b) -> b.length() - a.length());

        // 자주 나오는 단어일수록 앞에 배치
        keySet.sort((o1, o2) -> hashMap.get(o2).compareTo(hashMap.get(o1)));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < keySet.size(); i++) {
            bw.write(keySet.get(i) + "\n");
        }

        bw.flush();
        bw.close();
    }
}
