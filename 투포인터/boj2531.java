package 투포인터;

import java.util.*;
import java.io.*;

public class boj2531 {
    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int plates = Integer.parseInt(st.nextToken()); // N (접시의 수)
        int category = Integer.parseInt(st.nextToken()); // d (초밥의 가짓 수)
        int eat = Integer.parseInt(st.nextToken()); // k (연속해서 먹는 접시의 수)
        int coupon = Integer.parseInt(st.nextToken()); // c (쿠폰 번호 수)

        int[] arr = new int[plates];
        for (int i = 0; i < plates; i++) {
            // 한 줄마다 초밥의 종류 입력받기
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] sushiCount = new int[category + 1]; // 초밥 종류별로 저장하는 카테고리
        int currentType = 0;
        for (int i = 0; i < eat; i++) {
            if (sushiCount[arr[i]] == 0)
                // 처음 먹는 종류면 카운트 증가
                currentType++;
            sushiCount[arr[i]]++; // 자체 저장되어있는 값도 증가시켜주기
        }

        // 현재 기준 정답을 종류의 수 (쿠폰 더하기 전으로)
        int ans = currentType;

        for (int i = 0; i < arr.length; i++) {
            int total = currentType;
            // 쿠폰 없으면 하나 추가
            if (sushiCount[coupon] == 0)
                total++;

            // 저장되어있던 값이랑 total 중에 큰거
            ans = Math.max(ans, total);

            // 슬라이딩 윈도우 고고
            sushiCount[arr[i]]--; // 접시 하나 빼기
            if (sushiCount[arr[i]] == 0)
                currentType--; // 더 이상 이 종류가 없으면 카운트 감소

            // 다음 인덱스할건데 회전초밥이라 % 연산
            int nextIndex = (i + eat) % plates;
            if (sushiCount[arr[nextIndex]] == 0)
                currentType++;
            sushiCount[arr[nextIndex]]++;
        }

        System.out.println(ans);
    }
}
