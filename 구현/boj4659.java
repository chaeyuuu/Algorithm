package 구현;

import java.util.*;
import java.io.*;

public class boj4659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String word = br.readLine();
            if (word.equals("end")) {
                break;
            }

            boolean isVowel = false; // 1번
            boolean isFlag = true; // true여야 가능

            int vCount = 0; // 모음 카운트
            int cCount = 0; // 자음 카운트

            for (int i = 0; i < word.length(); i++) {
                char cur = word.charAt(i);
                // 모음 확인
                boolean isV = isVowel(cur);

                // 1번 (모음 하나 이상 포함)
                if (isV) {
                    isVowel = true;
                    vCount++;
                    cCount = 0;
                } else {
                    cCount++;
                    vCount = 0;
                }

                // 2번 (모음 혹은 자음이 3개 연속으로 오면 안됨)
                if (vCount >= 3 || cCount >= 3) {
                    isFlag = false;
                    break;
                }

                // 3번 같은 문자 연속으로 오면 안됨 (ee, oo 가능)
                if (i > 0) {
                    if (cur == word.charAt(i - 1)) {
                        if (cur != 'e' && cur != 'o') {
                            isFlag = false;
                            break;
                        }
                    }
                }
            }

            if (isFlag && isVowel) {
                System.out.println("<" + word + ">" + " is acceptable.");
            } else {
                System.out.println("<" + word + ">" + " is not acceptable.");
            }
        }
    }

    // 모음 확인 함수
    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}