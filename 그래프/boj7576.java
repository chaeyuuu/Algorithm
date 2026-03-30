package 그래프;

import java.io.*;
import java.util.*;

public class boj7576 {

    static int box[][];
    static boolean visited[][];
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, -1, 0, 1 };
    static Queue<int[]> tomatos = new LinkedList<>();;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken()); // 가로
        int N = Integer.parseInt(st.nextToken()); // 세로

        // 1 : 익은 토마토
        // 0 : 익지 않은 토마토
        // -1 :토마토 안 들어있는 곳

        box = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 1인 곳을 전부 queue에 넣기
                if (box[i][j] == 1 && visited[i][j] == false) {
                    tomatos.add(new int[] { i, j });
                    visited[i][j] = true;
                }
            }
        }

        bfs(tomatos, N, M);

        int maxDays = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    // bfs 다 돌고 0인 곳이 남아있으면 다 익지 못한 것
                    System.out.println(-1);
                    return;
                }

                maxDays = Math.max(maxDays, box[i][j]);
            }
        }

        // 처음 시작한 곳 빼기
        System.out.println(maxDays - 1);

    }

    static void bfs(Queue<int[]> tomatos, int N, int M) {
        // 1인 곳에서 시작
        // x가 가로, y가 세로
        while (!tomatos.isEmpty()) {
            int[] now = tomatos.poll();
            int curX = now[1];
            int curY = now[0];

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N) {
                    if (box[nextY][nextX] == 0 && visited[nextY][nextX] == false) {
                        // 0이고 방문 안 했으면 1로 바꾸고 visited true로 바꾸기
                        visited[nextY][nextX] = true;
                        box[nextY][nextX] = box[curY][curX] + 1;
                        tomatos.add(new int[] { nextY, nextX });
                    }
                }
            }
        }
    }
}
