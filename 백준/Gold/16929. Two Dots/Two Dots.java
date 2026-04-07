
import java.io.*;
import java.util.*;

public class Main {

    static boolean[][] visited;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, -1, 0, 1 };
    static char[][] game;
    static int n, m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        game = new char[n][m];
        visited = new boolean[n][m];
        String result;

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                game[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    if (dfs(j, i, -1, -1)) {
                        System.out.println("Yes");
                        return;
                    }
                }
            }
        }

        System.out.println("No");
        return;

    }

    public static boolean dfs(int x, int y, int pastX, int pastY) {
        visited[y][x] = true;
        char nowAlphabet = game[y][x];
        // 현재의 알파벳이랑 다음 알파벳 같은지 확인
        // 다르면 break;
        // 이미 방문했던 곳 다시 방문하면 사이클 완성
        // 근데 내가 이전에 왔던 곳이 아니여야함.
        // 넘길 때 내 이전 위치를 함께 넘기기
        for (int i = 0; i < 4; i++) {
            // 다음 알파벳이 지금 알파벳과 같고
            // 방문안한 곳이라면 이동
            // 이전에 왔던 곳도 아녀야함

            int nextX = x + dx[i];
            int nextY = y + dy[i];

            // 범위 내임
            if (nextX < m && nextX >= 0 && nextY < n && nextY >= 0) {
                // 알파벳이 같음
                if (nowAlphabet == game[nextY][nextX]) {
                    if (visited[nextY][nextX]) {
                        if (nextX != pastX || nextY != pastY)
                            // 사이클임
                            // 방문했던 곳인데 알파벳 같고
                            // 이전꺼랑 다르니까!!
                            return true;
                    } else if (!visited[nextY][nextX]) {
                        if (dfs(nextX, nextY, x, y))
                            return true;
                    }
                }

            }
        }

        return false;
    }

}
