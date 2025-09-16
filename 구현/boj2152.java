package 구현;

import java.util.*;
import java.io.*;

public class boj2152 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int total = 0;

        List<Integer> requests = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int request = Integer.parseInt(st.nextToken());
            total += request;
            requests.add(request);
        }

        int high = Collections.max(requests);
        int M = Integer.parseInt(br.readLine());

        if (total <= M) {
            System.out.println(high);
            return;
        }

        int low = 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int budget = 0; // 총 배정액

            for (int i = 0; i < N; i++) {
                // 요청액이 mid 넘으면 mid만 배정
                // 안 넘으면 원래 요청액만큼 배정
                if (requests.get(i) > mid) {
                    budget += mid;
                } else {
                    budget += requests.get(i);
                }
            }

            // 예산 이내면 늘리기 아니면 줄이기
            if (budget <= M) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        System.out.println(high);

    }

}
