package 구현;

import java.io.*;

public class boj1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] alphabetCounts = new int[26];
        String word = br.readLine().toLowerCase();

        // 각 알파벳의 빈도를 count하기
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            alphabetCounts[index]++;
        }

        int max = 0;
        char result = '?';

        for (int i = 0; i < 26; i++) {
            if (alphabetCounts[i] > max) {
                max = alphabetCounts[i];
                result = (char) ('A' + i);
            } else if (alphabetCounts[i] == max) {
                result = '?';
            }
        }
        System.out.print(result);
    }
}