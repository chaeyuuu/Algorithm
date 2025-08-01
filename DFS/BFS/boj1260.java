package DFS.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1260 {

    static ArrayList<Integer>[] graph;
    static boolean[] dfsVisited;
    static boolean[] bfsVisited;

    static StringBuilder dfsBr = new StringBuilder();
    static StringBuilder bfsBr = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            // 정점 i에 연결된 다른 정점들 저장
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        for(int i=1; i<=N; i++){
            Collections.sort(graph[i]);
        }

        dfsVisited = new boolean[N+1];
        dfs(V);

        bfsVisited = new boolean[N+1];
        bfs(V);

        System.out.println(dfsBr);
        System.out.println(bfsBr);
    }

    // 재귀
    static void dfs(int node) {
        dfsVisited[node] = true;
        dfsBr.append(node).append(" ");

        for (int next: graph[node]){
            // 방문하지 않았으면
            if (!dfsVisited[next]){
                dfs(next);
            }
        }
    }

    // 큐
    static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        bfsVisited[node] = true;

        while(!queue.isEmpty()){
            int cur = queue.poll();
            bfsBr.append(cur).append(" ");

            for (int next: graph[cur]){
                if (!bfsVisited[next]){
                    bfsVisited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}