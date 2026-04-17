import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] houses = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            // 윗줄 아랫줄과 같은 색이면 안됨
            // 비용의 최솟값 - dp
            houses[i][0] = Integer.parseInt(st.nextToken());
            houses[i][1] = Integer.parseInt(st.nextToken());
            houses[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            houses[i][0] += Math.min(houses[i - 1][1], houses[i - 1][2]);
            houses[i][1] += Math.min(houses[i - 1][0], houses[i - 1][2]);
            houses[i][2] += Math.min(houses[i - 1][0], houses[i - 1][1]);
        }

        int min = houses[N - 1][0];
        for (int i = 1; i < 3; i++) {
            if (min > houses[N - 1][i]) {
                min = houses[N - 1][i];
            }
        }

        System.out.println(min);

    }

}
