package 그래프;
import java.util.*;
import java.io.*;

public class boj1260 {
    static int[][] graph; // 인접행렬
    static boolean[] visited; // 방문 체크 배열
    static int N, M, V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        M = Integer.parseInt(st.nextToken()); // 간선의 개수
        V = Integer.parseInt(st.nextToken()); // 탐색 시작할 정점의 번호
        graph = new int[N + 1][N + 1];

        // DFS - 깊이 우선 (재귀, stack)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }

        visited = new boolean[N + 1];
        dfs(V);

        System.out.println();

        visited = new boolean[N + 1];
        bfs(V);
    }

    static void dfs(int start) {
        // 재귀
        visited[start] = true;
        System.out.print(start + " ");

        for (int i = 1; i < N + 1; i++) {
            if (visited[i] == false && graph[start][i] == 1) {
                // 연결이 되어있고 방문 아직 안 했으면
                dfs(i);
            }
        }
    }

    static void bfs(int start) {
        // 큐
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");

            for (int i = 1; i < N + 1; i++) {
                if (visited[i] == false && graph[now][i] == 1) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

}
