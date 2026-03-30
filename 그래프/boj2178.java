package 그래프;

import java.util.*;
import java.io.*;

// 최단거리는 bfs
// 거리가 가까운거부터 순차적으로 탐색해나가니까

public class boj2178 {

    static int graph[][];
    static boolean visited[][];
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, -1, 0, 1 };

    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }

        // 세로가 N y
        // 가로가 M x
        bfs(0, 0, N, M);
        System.out.println(graph[N - 1][M - 1]);
    }

    static void bfs(int x, int y, int N, int M) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { y, x });
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int curX = now[1];
            int curY = now[0];

            if (curX == M - 1 && curY == N - 1) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N) {
                    if (visited[nextY][nextX] == false && graph[nextY][nextX] == 1) {
                        graph[nextY][nextX] = graph[curY][curX] + 1;
                        visited[nextY][nextX] = true;
                        queue.add(new int[] { nextY, nextX });
                    }
                }
            }

        }

    }

}
