package 그래프;

import java.io.*;
import java.util.*;

public class boj14940 {

    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, -1, 0, 1 };

    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int height = Integer.parseInt(st.nextToken()); // 세로
        int width = Integer.parseInt(st.nextToken()); // 가로

        map = new int[height][width];
        visited = new boolean[height][width];

        // 0: 갈 수 없는 땅
        // 1: 갈 수 있는 땅
        // 2: 목표 지점

        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (!visited[i][j] && map[i][j] == 2) {
                    // 방문하지 않았고 2면 목표지점 bfs 호출
                    // 근데.. 2가 0이 되어야함!!! 그래야 더했을 때 원래대로 됨
                    map[i][j] = 0;
                    visited[i][j] = true;
                    // i가 세로니까 y 위치로 넘겨야함
                    bfs(j, i, height, width);
                    break;
                }
            }
        }

        // 원래 갈 수 있는 땅인데 도달할 수 없는 위치는 -1
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    map[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < height; i++) {
            if (i != 0)
                System.out.println();
            for (int j = 0; j < width; j++) {
                System.out.print(map[i][j] + " ");
            }
        }

    }

    static void bfs(int x, int y, int height, int width) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { y, x });
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int curX = now[1];
            int curY = now[0];

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX < width && nextX >= 0 && nextY < height && nextY >= 0) {
                    if (!visited[nextY][nextX] && map[nextY][nextX] == 1) {
                        visited[nextY][nextX] = true;
                        map[nextY][nextX] = map[curY][curX] + 1;
                        queue.add(new int[] { nextY, nextX });
                    }
                }
            }
        }
    }
}
