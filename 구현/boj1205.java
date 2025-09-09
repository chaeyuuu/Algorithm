package 구현;

import java.io.*;
import java.util.*;

// 랭킹 리스트에 올라갈 수 있는 점수 P
// 리스트에 있는 점수 N개
// 태오의 새로운 점수

public class boj1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;

        int N = Integer.parseInt(st.nextToken());
        int newScore = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        if (N != 0)
            st = new StringTokenizer(br.readLine());

        Integer[] ranking = new Integer[N + 1];

        for (int i = 0; i < N; i++) {
            ranking[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ranking, 0, N, Collections.reverseOrder());

        if (P == N) {
            if (ranking[N - 1] < newScore) {
                ranking[N - 1] = newScore;
                Arrays.sort(ranking, 0, N, Collections.reverseOrder());
            } else {
                result = -1;
            }
        } else {
            ranking[N] = newScore;
            Arrays.sort(ranking, Collections.reverseOrder());
        }

        if (result == -1) {
            System.out.println(result);
        } else {
            for (int i = 0; i <= N; i++) {
                if (ranking[i] == newScore) {
                    System.out.println(i + 1);
                    break;
                }
            }
        }
    }
}