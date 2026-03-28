package 그래프;

import java.util.*;
import java.io.*;

public class boj1012 {

    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, -1, 0, 1 };
    static int[][] graph;

    static int M;
    static int N;
    static int K;

    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            int count = 0;
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로 길이
            N = Integer.parseInt(st.nextToken()); // 세로 길이
            K = Integer.parseInt(st.nextToken()); // 배추가 심어져 있는 위치의 개수

            graph = new int[N][M];
            visited = new boolean[N][M];

            for (int j = 0; j < K; j++) {
                // 입력 받은 위치가 배추가 1
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[y][x] = 1;
            }

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (graph[j][k] == 1 && visited[j][k] == false) {
                        dfs(j, k);
                        count += 1;
                    }
                }
            }

            System.out.println(count);

        }

    }

    static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny < N && ny >= 0 && nx < M) {
                if (graph[ny][nx] == 1 && visited[ny][nx] == false) {
                    visited[ny][nx] = true;
                    dfs(ny, nx);
                }
            }
        }
    }
}
