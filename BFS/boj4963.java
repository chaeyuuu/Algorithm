package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj4963 {

    static StringTokenizer st;
    static int[] dirX = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dirY = {0, -1, -1, -1, 0, 1, 1, 1};
    static int w, h;

    static boolean[][] visited;
    static int[][] island;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            int count = 0;

            if (w == 0 && h == 0) break;

            island = new int[h][w];
            visited = new boolean[h][w];

            for (int y = 0; y < h; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < w; x++) {
                    island[y][x] = Integer.parseInt(st.nextToken());
                }
            }

            for (int y = 0; y < h; y++) {
                for (int x = 0; x < w; x++) {
                    if (!visited[y][x] && island[y][x] == 1) {
                        count++;
                        bfs(x, y);
                    }
                }
            }

            System.out.println(count);
        }

    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 8; i++) {
                int nextX = nowX + dirX[i];
                int nextY = nowY + dirY[i];

                if (nextX >= 0 && nextX < w &&
                        nextY >= 0 && nextY < h
                        && !visited[nextY][nextX] && island[nextY][nextX] == 1) {
                    visited[nextY][nextX] = true;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
    }
}
}
