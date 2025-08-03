package DFS.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj2644 {

    static ArrayList<Integer>[] graph;
    static boolean[] visitedBfs;
    static boolean[] visitedDfs;
    static int a, b;
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        visitedDfs = new boolean[n + 1];
        dfs(a, 0);
        System.out.println(result);
    }

    static void dfs(int node, int depth) {
        visitedDfs[node] = true;

        if (node == b) {
            result = depth;
        }
        for (int next : graph[node]) {
            if (!visitedDfs[next]) {
                dfs(next, depth + 1);
            }
        }
    }
}
