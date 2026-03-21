package 해쉬;

import java.util.*;
import java.io.*;

public class boj2607 {
    public static void main(String args[]) throws IOException {
        // 두 개의 단어가 같은 종류의 문자
        // 같은 문자는 같은 개수

        // 첫 문자가 기준이 됨

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String word = br.readLine();
        char[] arr = word.toCharArray();
        Map<Character, Integer> hashMap = new HashMap<>();
        int result = 0;

        for (int i = 0; i < arr.length; i++) {

            char c = arr[i];
            // hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);

            if (hashMap.containsKey(c)) {
                hashMap.put(c, hashMap.get(c) + 1);
            } else {
                hashMap.put(c, 1);
            }
        }

        for (int i = 0; i < N - 1; i++) {
            // 입력 받고 기준과 비교
            String input = br.readLine();
            char[] inputChar = input.toCharArray();
            Map<Character, Integer> inputMap = new HashMap<>();

            // 입력 받은 애 확인
            for (int j = 0; j < inputChar.length; j++) {
                char c = inputChar[j];
                // hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);

                if (inputMap.containsKey(c)) {
                    inputMap.put(c, inputMap.get(c) + 1);
                } else {
                    inputMap.put(c, 1);
                }
            }

            // 기준이랑 비교하기
            // hashMap이랑 inputMap이랑 비교

            // 만약에 길이 같은데 diff 하나 차이면 reslut +=1;
            // 글자 길이 1개차인데 diff 하나 차이면 result +=1;
            // 글자 차이 2이상이면 패스

            int diff = 0; // 같은 알파벳끼리의 개수 차이
            for (char c = 'A'; c <= 'Z'; c++) {
                int count1 = hashMap.getOrDefault(c, 0);
                int count2 = inputMap.getOrDefault(c, 0);

                diff += Math.abs(count1 - count2);
            }

            if (inputChar.length == arr.length && diff <= 2) {
                result += 1;
            } else if (inputChar.length != arr.length && diff <= 1) {
                result += 1;
            }
        }

        System.out.println(result);

    }

}
