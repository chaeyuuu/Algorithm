package BFS;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj2606 {

    static ArrayList<Integer>[] graph;
    static boolean[] dfsVisited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));

        int computerNum = Integer.parseInt(br.readLine());
        int connectedComp = Integer.parseInt(br.readLine());

        graph = new ArrayList[computerNum + 1];
        for (int i = 1; i <= computerNum; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= connectedComp; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= computerNum; i++) {
            Collections.sort(graph[i]);
        }

        dfsVisited = new boolean[computerNum + 1];
        dfs(1);

        System.out.println(count - 1);
    }

    static void dfs(int computer) {
        dfsVisited[computer] = true;
        count += 1;

        for (int next : graph[computer]) {
            if (!dfsVisited[next]) {
                dfs(next);
            }
        }
    }
}
