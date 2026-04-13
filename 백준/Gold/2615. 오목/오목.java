import java.util.*;
import java.io.*;

public class Main {

    static int[][] boards;

    static int[] dx = { 1, 1, 1, 0 };
    static int[] dy = { -1, 0, 1, 1 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        boards = new int[20][20];

        for (int i = 1; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 20; j++) {
                boards[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 열부터 탐색 (y)
        for (int j = 1; j < 20; j++) {
            for (int i = 1; i < 20; i++) {
                if (boards[i][j] != 0) {
                    int color = boards[i][j];

                    for (int d = 0; d < 4; d++) {
                        if (check(j, i, d, color)) {
                            // 승리한 색깔과 좌표 출력 후 종료
                            // 가장 왼쪽에 있는 바둑알(연속된 다섯 개의 바둑알이 세로로 놓인 경우
                            // 그 중 가장 위에 있는 것)의 가로줄 번호와, 세로줄 번호를 순서대로 출력
                            System.out.println(color);
                            System.out.println(i + " " + j); // 가로, 세로
                            return;
                        }
                    }

                }
            }
        }

        System.out.println(0);

    }

    static boolean isRange(int x, int y) {
        return x >= 1 && x <= 19 && y >= 1 && y <= 19;
    }

    static boolean check(int x, int y, int d, int color) {
        int prevX = x - dx[d];
        int prevY = y - dy[d];

        // 내 전에 같은 색 돌이 있으면 내가 시작점이 아님 .. 흑흑
        if (isRange(prevX, prevY) && boards[prevY][prevX] == color) {
            return false;
        }

        int count = 1;

        for (int t = 1; t < 5; t++) {
            // 5칸 확인
            int nextX = x + dx[d] * t;
            int nextY = y + dy[d] * t;

            if (isRange(nextX, nextY) && boards[nextY][nextX] == color)
                count++;
            else
                break;
        }

        if (count == 5) {
            // 5칸 채웠음
            int next6X = x + dx[d] * 5;
            int next6Y = y + dy[d] * 5;
            if (isRange(next6X, next6Y) && boards[next6Y][next6X] == color) {
                return false;
            }

            return true;

        }

        return false;
    }

}