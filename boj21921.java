import java.io.*;
import java.util.*;

public class boj21921 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int day = Integer.parseInt(st.nextToken()); // 블로그 시작하고 지난 일수 N
        int X = Integer.parseInt(st.nextToken()); // X일동안 가장 많이 들어온 방문자 수

        int[] dayArr = new int[day];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < dayArr.length; i++) {
            dayArr[i] = Integer.parseInt(st.nextToken());
        }

        // int[] countArr = new int[8001];

        int maxNum = 0; // X 기간 동안 가장 많이 들어온 방문자 수
        // 최대 방문자 수 0명이면 SAD
        int start = 0;
        int end = 0;
        int count = 0;
        for (int i = 0; i < dayArr.length; i++) {
            // X기간 동안
            start = i; // 0
            end = start + X; // 2
            int total = 0;

            if (end > dayArr.length)
                break;

            for (int j = start; j < end; j++) {
                total += dayArr[j]; // 5
                // System.out.println("j: " + j + ", total: " + total);
            }

            // System.out.println("max전 maxNum: " + maxNum + " , count: " + count + "
            // ,total: " + total);

            // 최댓값이 되면 count 1증가
            // 이번 최댓값도 전이랑 똑같으면 계속 증가
            // 만약에 최댓값이 갱신되었으면 count 1으로 바꿈

            if (total != 0 && total == maxNum)
                count++;
            else if (total > maxNum) {
                count = 1;
            }

            maxNum = Math.max(total, maxNum);

            // System.out.println("max후 maxNum: " + maxNum + " , count: " + count + "
            // ,total: " + total);

        }

        if (maxNum == 0) {
            System.out.println("SAD");
            return;
        } else {
            System.out.println(maxNum);
            System.out.println(count);
        }

    }

}
