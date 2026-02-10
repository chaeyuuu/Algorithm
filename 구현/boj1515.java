package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1515 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();

        int ptr = 0; // 지워지고 남은 수가 어디 찾고 있는지 나타낼 포인터
        int n = 0; // 1부터 증가시킬 생각

        while (true) {
            n++;
            String s = String.valueOf(n);

            // 현재 숫자 n의 각 자릿수 하나씩 확인
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == number.charAt(ptr)) {
                    ptr++;
                }

                // 마지막이랑 같으면
                if (ptr == number.length()) {
                    System.out.println(n);
                    return;
                }
            }
        }
    }
}
