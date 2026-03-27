package 그래프;
import java.util.*;
import java.io.*;

public class boj2606 {
    static boolean[] visited;
    static int[][] graph;
    static int N;
    static int count;

    public static void main(String[] args) throws IOException {
        // dfs
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());

        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = graph[b][a] = 1;
        }

        count = 0;
        dfs(1);
        System.out.println(count);

    }

    static void dfs(int start) {
        visited[start] = true;
        for (int i = 1; i < N + 1; i++) {
            if (visited[i] == false && graph[start][i] == 1) {
                dfs(i);
                count += 1;
            }
        }

    }
}
