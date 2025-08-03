package DFS.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj11724 {
    static boolean[] visitedDfs;
    static ArrayList<Integer>[] graph;
    static int count;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[v].add(u);
            graph[u].add(v);
        }

        visitedDfs = new boolean[N + 1];
        // dfs(1);
        for (int i = 1; i <= N; i++) {
            if (!visitedDfs[i]) {
                count += 1;
                dfs(i);
            }
        }
        System.out.println(count);
    }

    static void dfs(int node) {
        visitedDfs[node] = true;

        for (int next : graph[node]) {
            if (!visitedDfs[next]) {
                dfs(next);
            }
        }

    }
}