package DFS.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class boj1012 {

    static int map[][];
    static boolean[][] visited;

    static int dirX[] = {0, 0, -1, 1};
    static int dirY[] = {-1, 1, 0, 0};
    static int M, N, K;
    static int count;
    static int nowX, nowY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            count = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[j][k] == 1 && !visited[j][k]) {
                        count++;
                        // dfs(k, j);
                        bfs(k, j);
                    }
                }
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }

    static void dfs(int x, int y) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            nowX = x + dirX[i];
            nowY = y + dirY[i];

            if (nowX >= 0 && nowX < M && nowY >= 0 && nowY < N
                    && !visited[nowY][nowX]
                    && map[nowY][nowX] == 1) {
                dfs(nowX, nowY);
            }
        }
    }

    static void bfs(int x, int y) {
        // 큐 안에 int 배열 들어감
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            nowX = now[0];
            nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dirX[i];
                int nextY = nowY + dirY[i];

                if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N && !visited[nextY][nextX]
                        && map[nextY][nextX] == 1) {
                    visited[nextY][nextX] = true;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
    }
}
