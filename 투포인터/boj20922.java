package 투포인터;

import java.io.*;
import java.util.*;

public class boj20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int length = Integer.parseInt(st.nextToken()); // 수열 길이
        int maxNum = Integer.parseInt(st.nextToken()); // 같은 정수 최대 개수

        int[] arr = new int[length];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int maxLength = 0;

        for (int end = 0; end < arr.length; end++) {
            int currentKey = arr[end];

            // 현재 숫자 map에 추가
            map.put(currentKey, map.getOrDefault(currentKey, 0) + 1);

            // 만약 지금 숫자의 개수가 maxNum보다 크면
            // 작아질 때까지 start를 오른쪽으로 땡겨오기
            while (map.get(currentKey) > maxNum) {
                int startNum = arr[start];
                // map에서 startNum 값을 빼고 카운트도 하나 줄이기
                map.put(startNum, map.get(startNum) - 1);
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        System.out.println(maxLength);
    }
}
