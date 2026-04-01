package 투포인터;

import java.io.*;
import java.util.*;

public class boj2531 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int plates = Integer.parseInt(st.nextToken()); // N: 접시의 수
        int sushiType = Integer.parseInt(st.nextToken()); // d: 초밥의 가짓수
        int eatPlates = Integer.parseInt(st.nextToken()); // k: 연속해서 먹는 접시 수
        int coupon = Integer.parseInt(st.nextToken()); // c: 쿠폰 번호

        int[] sushi = new int[plates];

        for (int i = 0; i < plates; i++) {
            // 초밥 종류 sushi 배열에 저장
            sushi[i] = Integer.parseInt(br.readLine());
            // [7,9,7,30,2,7,9,25]
        }

        int[] count = new int[sushiType + 1];
        int currentType = 0;

        for (int i = 0; i < eatPlates; i++) {
            if (count[sushi[i]] == 0)
                // 처음 먹는 종류면 카운트 증가
                currentType++;
            count[sushi[i]]++; // 자체 저장되어있는 값도 증가시켜주기
        }

        int ans = currentType;

        // 처음 k개 다하면 이제 슬라이딩 윈도우
        for (int i = 0; i < sushi.length; i++) {
            int total = currentType;
            // 카운트 센 값 중에 쿠폰 번호에 해당하는 값이
            // 0아면 쿠폰 번호가 포함되어있지 않다는 뜻
            if (count[coupon] == 0) {
                total += 1;
            }

            ans = Math.max(total, ans);

            // 이제 슬라이딩 윈도우
            count[sushi[i]]--;
            if (count[sushi[i]] == 0) {
                currentType--;
            }

            int nextIndex = (i + eatPlates) % plates;
            if (count[sushi[nextIndex]] == 0)
                currentType++;
            count[sushi[nextIndex]]++;

        }

        System.out.println(ans);

    }

}
