package DFS.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class boj2667 {

    static int[][] map;
    static boolean[][] visited;

    static int[] dirX = {1, 0, -1, 0};
    static int[] dirY = {0, -1, 0, 1};
    static int N;
    static ArrayList<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];

        for (int y = 0; y < N; y++) {
            String input = br.readLine();
            for (int x = 0; x < N; x++) {
                int inputNum = Character.getNumericValue(input.charAt(x));
                map[y][x] = inputNum;
            }
        }

        result = new ArrayList<>();

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (map[y][x] == 1 && !visited[y][x]){
                    result.add(bfs(x,y));
                }
            }
        }

        Collections.sort(result);

        System.out.println(result.size());
        for (int i=0; i<result.size(); i++){
            System.out.println(result.get(i));
        }
    }

    static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[y][x] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nextX = dirX[i] + nowX;
                int nextY = dirY[i] + nowY;

                if (nextX >= 0 && nextX < N
                        && nextY >= 0 && nextY < N
                        && !visited[nextY][nextX] && map[nextY][nextX] == 1) {
                    visited[nextY][nextX] = true;
                    queue.add(new int[]{nextX, nextY});
                }
            }
            count++;
        }
        return count;
    }
}