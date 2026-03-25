package 구현;

import java.util.*;
import java.io.*;

public class boj2304 {
    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[1001];
        int minL = 1001; // 시작 위치
        int maxL = 0; // 끝위치
        int maxH = 0; // 가장 높은 기둥의 높이
        int maxPos = 0; // 가장 높은 기둥의 위치

        // 물이 고이지 않으려면 산 모양으로 가야함
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 배열에 x,y 저장
            int L = Integer.parseInt(st.nextToken()); // 위치
            int H = Integer.parseInt(st.nextToken()); // 높이

            arr[L] = H;

            if (arr[L] > maxH) {
                // 가장 높은 높이
                maxH = arr[L]; // 현재 기둥의 높이를 가장 높은 기둥의 높이로 변경
                maxPos = L; // 현재 기둥의 위치를 가장 높은 기둥의 위치로 변경
            }

            minL = Math.min(minL, L);
            maxL = Math.max(maxL, L);
        }

        int curMax = 0; // 현재 가장 높은 기둥의 높이
        int total = 0;
        // 가장 기둥 높은 애 전까지
        for (int i = minL; i < maxPos; i++) {
            curMax = Math.max(curMax, arr[i]);
            total += curMax;
        }

        total += maxH;

        curMax = 0;
        for (int i = maxL; i > maxPos; i--) {
            curMax = Math.max(curMax, arr[i]);
            total += curMax;
        }

        System.out.println(total);
    }

}
