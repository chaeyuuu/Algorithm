import java.util.*;
import java.io.*;

public class boj1446 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken()); // N: 지름길의 개수
        int highway = Integer.parseInt(st.nextToken()); // D: 고속도로의 길이

        int[][] arr = new int[num][3]; // 지름길 정보
        int[] dp = new int[highway + 1];

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken()); // 시작 위치
            int destination = Integer.parseInt(st.nextToken()); // 도착 위치
            int length = Integer.parseInt(st.nextToken()); // 지름길 길이

            arr[i][0] = start;
            arr[i][1] = destination;

            if (destination - start < length) {
                // 지름길이 더 먼 경우
                arr[i][2] = destination - start;

            } else {
                arr[i][2] = length;
            }
        }

        // 그냥 가는게 가까우면 한칸 이동하고
        // 현재 내 위치에서 지름길이 있는데 그게 더 가까우면 그 지름길의 도착지(end) 갱신
        for (int i = 0; i <= highway; i++) {
            dp[i] = i;
        }

        int move = 0;
        while (move < highway) {
            // 고속도로 끝에 도달할때까지 반복
            // dp[move]+1 이 내가 지금 걷는길임 한칸씩 이동하는거니까
            if (dp[move + 1] > dp[move] + 1) {
                dp[move + 1] = dp[move] + 1;
            }

            // 지름길 확인해보기
            for (int i = 0; i < num; i++) {
                if (arr[i][0] == move) {
                    // 지금 위치에 지름길이 있으면
                    int end = arr[i][1];
                    int len = arr[i][2];

                    if (end <= highway && dp[end] > dp[move] + len) {
                        // 지름길의 도착지가 고속도로 길이보다 작고
                        // 현재 저장되어있는 길이보다 지름길 + 현재까지 이동해온 길이가 작으면
                        dp[end] = dp[move] + len;
                    }

                }
            }

            move++;

        }

        System.out.println(dp[highway]);

    }

}
