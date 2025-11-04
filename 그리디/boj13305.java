package 그리디;

import java.util.*;
import java.io.*;

public class boj13305 {
    public static void main(String[] agrs) throws IOException {
        // 동그라미 안에 도시에 있는 주유소의 리터당 가격
        // 도로 위의 숫자는 도로의 길이 표시
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cityNum = Integer.parseInt(br.readLine());
        long[] distances = new long[cityNum - 1];
        long[] prices = new long[cityNum];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cityNum - 1; i++) {
            distances[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cityNum - 1; i++) {
            prices[i] = Long.parseLong(st.nextToken());
        }

        long totalCost = 0;
        long minPrices = prices[0];

        // 더 저렴한 가격을 만나기 전까지 이 전의 저렴한 가격으로 진행
        // 첫 번째 주유소에서는 최소 다음 도시로 가는데 필요한 기름의 양만큼은 넣어야함
        for (int i = 0; i < cityNum - 1; i++) {
            // 다음 도시로 가는데 필요한 양
            totalCost += distances[i] * minPrices;

            // 최소 가격 업데이트
            // 저렴하면 업데이트
            if (prices[i + 1] < minPrices) {
                minPrices = prices[i + 1];
            }
        }
        System.out.println(totalCost);
    }
}
