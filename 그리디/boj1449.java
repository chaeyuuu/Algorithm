package 그리디;

import java.util.*;
import java.io.*;

public class boj1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken()); // 테이프의 길이

        int[] leaks = new int[N]; // 물이 새는 위치
        boolean[] repaired = new boolean[N]; // 물 막은 곳

        double covered = 0;
        int count = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            leaks[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(leaks);

        // 물 막은 곳이 커버 범위 내면 넘어가고
        // 커버 범위 밖으로 넘어가면 테이프 다시 붙이고 테이프 +1
        // 커버 범위는 누수위치 +- 0.5 여야함
        for (int i = 0; i < N; i++) {
            if (leaks[i] + 0.5 > covered) {
                covered = leaks[i] - 0.5 + L;
                count += 1;
            }
        }
        System.out.println(count);
    }
}
