package 구현;

import java.util.*;
import java.io.*;

public class boj3758 {
    // k개의 문제
    // 팀ID, 문제 번호, 점수 -> 서버 로그에 제출되는 시간 순서대로 저장됨
    // 한 문제에 대한 풀이 여러 번 제출 가능 -> 그 중 최고 점수가 최종 점수
    // 어떤 문제에 대해 한 번도 제출하지 않았으면 최종 점수 0

    // 팀의 최종 점수는 각 문제의 최종 점수 총합

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 데이터 개수
        for (int x = 0; x < T; x++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 팀의 개수 n, 문제의 개수 k, 당신 팀의 ID t, 로그 엔트리의 개수 m
            int n = Integer.parseInt(st.nextToken()); // 3
            int k = Integer.parseInt(st.nextToken()); // 4
            int t = Integer.parseInt(st.nextToken()); // 3
            int m = Integer.parseInt(st.nextToken()); // 5

            int[][] arr = new int[n + 1][k + 1]; // 3, 4
            int[] submit = new int[n + 1]; // 제출 횟수
            int[] lastSubmit = new int[n + 1]; // 마지막 제출 시간

            for (int y = 0; y < m; y++) { // 5개 로그
                // 팀 ID i, 문제 번호 j, 획득한 점수 s
                st = new StringTokenizer(br.readLine());

                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                arr[i][j] = Math.max(arr[i][j], s);
                submit[i]++; // 제출 횟수 증가
                lastSubmit[i] = y; // 로그 순서 저장
            }

            int[] total = new int[n + 1];

            // 팀 별 최종 점수 합계 구하기
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < k + 1; j++) {
                    total[i] += arr[i][j];
                }
            }

            int rank = 1;
            for (int i = 1; i < n + 1; i++) {
                if (i == t)
                    continue; // 내 팀 건너뜀

                if (total[i] < total[t]) {
                    continue;
                } else if (total[i] > total[t]) { // 내 팀보다 잘 한 경우 내 등수 하나 떨어짐
                    rank++;
                    continue;
                } else if (total[i] == total[t]) { // 동일 점수의 경우
                    // 1. 풀이 제출 횟수 적은 팀이 높음
                    if (submit[i] < submit[t]) {
                        rank++;
                        continue;
                    } else if (submit[i] == submit[t]) {
                        // 2. 최종 점수랑 횟수가 같으면 마지막 제출 시간이 더 빠른 팀의 순위가 높음
                        if (lastSubmit[i] < lastSubmit[t]) {
                            rank++;
                        }
                    }
                }
            }

            System.out.println(rank);

        }
    }
}
