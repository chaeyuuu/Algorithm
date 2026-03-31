package 그래프;

import java.io.*;
import java.util.*;

public class boj7576 {

    static int[][] tomatos;
    static boolean[][] visited;

    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, -1, 0, 1 };

    static Queue<int[]> starts;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken()); // 가로
        int N = Integer.parseInt(st.nextToken()); // 세로

        tomatos = new int[N][M];
        visited = new boolean[N][M];
        starts = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomatos[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && tomatos[i][j] == 1) {
                    // 방문하지 않았고 1이면 큐에 등록
                    starts.add(new int[] { i, j });
                    visited[i][j] = true;
                }
            }
        }

        // bfs 실행
        bfs(starts, N, M);

        // 돌고 만약에 아직 0이 남아있으면 -1
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomatos[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        // 아니라면 최소 날짜 출력
        int maxDay = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                maxDay = Math.max(maxDay, tomatos[i][j]);
            }
        }

        System.out.println(maxDay - 1);
    }

    static void bfs(Queue<int[]> starts, int N, int M) {
        // 모두 익을 때까지의 최소 날짜니까 칸에다가 +1

        // 이미 큐에 등록되어져왔으니까 바로
        while (!starts.isEmpty()) {
            int[] now = starts.poll();
            int curX = now[1];
            int curY = now[0];

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX < M && nextY < N && nextX >= 0 && nextY >= 0) {
                    // 방문 안 했고 0이면
                    if (!visited[nextY][nextX] && tomatos[nextY][nextX] == 0) {
                        tomatos[nextY][nextX] = tomatos[curY][curX] + 1;
                        visited[nextY][nextX] = true;
                        starts.add(new int[] { nextY, nextX });
                    }
                }
            }

        }

    }

}
