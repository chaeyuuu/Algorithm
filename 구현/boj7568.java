package 구현;

import java.io.*;
import java.util.*;

public class boj7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // 2차원 배열
        int[][] people = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            people[i][0] = x;
            people[i][1] = y;
        }

        // 등수 계산 로직
        int[] rank = new int[N];
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N; j++) {
                if (i == j)
                    continue;
                if (people[i][0] < people[j][0] && people[i][1] < people[j][1]) {
                    count += 1;
                }
            }
            rank[i] = count;
        }

        for (int i = 0; i < N; i++) {
            System.out.print(rank[i] + " ");
        }
    }
}