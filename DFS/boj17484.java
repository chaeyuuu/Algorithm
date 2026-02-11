package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj17484 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[][] space;
    static int min = Integer.MAX_VALUE;
    static int[] direction = { -1, 0, 1 };

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        space = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 전에 움직인 방향으로 움직일 수 없음 = 같은 방향으로 두 번 연속 움직일 수 없음
        // 그리디가 안 되는 이유는 더 최적의 값이 안 나올 수가 있음
        // 연료 최대한 아낌 -> dp... 아니면 dfs
        // 우주선이 움직일 수 있는 방향은 왼쪽아래 대각선, 아래, 오른쪽아래대각선

        for (int i = 0; i < M; i++) {
            solve(0, i, -1, space[0][i]);
        }

        System.out.println(min);

    }

    public static void solve(int i, int j, int prevDir, int sum) {
        // 달에 도착
        if (i == N - 1) {
            min = Math.min(sum, min);
            return;
        }

        for (int k = 0; k < 3; k++) {
            if (k == prevDir)
                continue;

            int nextJ = j + direction[k];
            if (nextJ >= 0 && nextJ < M) {
                solve(i + 1, nextJ, k, sum + space[i + 1][nextJ]);
            }
        }
    }

}
