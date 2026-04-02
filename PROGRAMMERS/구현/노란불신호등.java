package 구현;

public class 노란불신호등 {
    class Solution {
        public int solution(int[][] signals) {
            // n개의 신호등
            int n = signals.length;

            int[] totalCycle = new int[n];
            for (int i = 0; i < n; i++) {
                totalCycle[i] = signals[i][0] +
                        signals[i][1] + signals[i][2];
            }

            // 최대 탐색 범위 설정
            for (int i = 1; i < 10000000; i++) {
                boolean allYellow = true;

                for (int j = 0; j < n; j++) {
                    int green = signals[j][0]; // 2
                    int yellow = signals[j][1]; // 3
                    int total = totalCycle[j]; // 7

                    int currentTime = (i - 1) % total;

                    // 노란불인 구간은
                    // green <= currentTime < green+yellow
                    if (!(currentTime < green + yellow && green <= currentTime)) {
                        allYellow = false;
                        break;
                    }
                }
                if (allYellow)
                    return i;

            }

            return -1;

        }

    }

}
