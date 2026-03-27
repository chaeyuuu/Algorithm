package 그래프;

import java.util.*;
import java.io.*;

public class boj2667 {
    static int N;
    static int[][] graph;
    static boolean[][] visited = new boolean[N][N];

    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    static int count;

    public static void main(String[] args) throws IOException {
        // 1은 집, 0은 집 없
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                // 문자 숫자로 변환
                graph[i][j] = line.charAt(j) - '0';
            }

        }

        visited = new boolean[N][N];

        // (0,0)에서 시작
        // dx, dy 방향으로 탐색 시작
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == false & graph[i][j] == 1) {
                    count = 0;
                    dfs(i, j);
                    result.add(count);
                }
            }

        }

        // 정렬
        Collections.sort(result);

        System.out.println(result.size());
        for (int c : result)
            System.out.println(c);
    }

    static void dfs(int x, int y) {
        visited[x][y] = true; // 방문한걸로 변경
        count += 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (graph[nx][ny] == 1 && visited[nx][ny] == false) {
                    dfs(nx, ny);
                }
            }
        }

    }
}
