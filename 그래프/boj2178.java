package 그래프;

import java.util.*;
import java.io.*;

public class boj2178 {

    static int[][] graph;
    static boolean[][] visited;

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

        bfs(0, 0, N, M);
        System.out.println(graph[N - 1][M - 1]);

    }

    static void bfs(int x, int y, int N, int M) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { y, x });
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int curY = now[0]; // 현재 위치
            int curX = now[1];

            if (curY == N - 1 && curX == M - 1) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    if (visited[ny][nx] == false && graph[ny][nx] == 1) {
                        graph[ny][nx] = graph[curY][curX] + 1; // 다음 방문을 지금꺼 + 1
                        visited[ny][nx] = true; // 방문했다고 표시하기
                        queue.add(new int[] { ny, nx });
                    }
                }
            }
        }
    }
}
