package 그래프;

import java.io.*;
import java.util.*;

public class boj2583 {

    static int[][] graph;
    static boolean[][] visited;
    static int dx[] = { 1, 0, -1, 0 };
    static int dy[] = { 0, -1, 0, 1 };
    static ArrayList<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken()); // 5 세로
        int N = Integer.parseInt(st.nextToken()); // 7 가로
        int K = Integer.parseInt(st.nextToken()); // 사각형 개수 입력

        graph = new int[M][N];
        visited = new boolean[M][N];
        result = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());
            int rx = Integer.parseInt(st.nextToken());
            int ry = Integer.parseInt(st.nextToken());
            // (0,2) (4,4)
            // -> (0,3) (4,1)

            // ly = Math.abs(ly - M);
            // ry = Math.abs(ry - M);

            // (1,1) (2,5)
            // ->(1,4) (2,0)

            // 가로는 유지하고 세로만 더해서 M 나오게
            // 이 직사각형 부분 다 101로 채우기

            for (int j = ly; j < ry; j++) {
                for (int k = lx; k < rx; k++) {
                    graph[j][k] = 101;
                    visited[j][k] = true;
                }
            }

        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 0 && visited[i][j] == false) {
                    int area = bfs(j, i, N, M);
                    result.add(area);
                }
            }
        }

        Collections.sort(result);

        System.out.println(result.size());

        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }

    static int bfs(int x, int y, int N, int M) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { y, x });
        visited[y][x] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int curX = now[1];
            int curY = now[0];

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                    if (visited[nextY][nextX] == false && graph[nextY][nextX] == 0) {
                        queue.add(new int[] { nextY, nextX });
                        visited[nextY][nextX] = true;
                        count += 1;
                    }
                }
            }
        }

        return count;
    }

}
