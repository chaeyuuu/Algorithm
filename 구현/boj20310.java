package 구현;

import java.util.*;
import java.io.*;

public class boj20310 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력받기
        // 0은 앞에서부터 지우고
        // 1은 뒤에서부터 지우기

        String input = br.readLine();
        char[] arr = input.toCharArray();

        int zero = 0;
        int one = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '0')
                zero++;
            else
                one++;
        }

        int delZero = zero / 2;
        int delOne = one / 2;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '1' && delOne > 0) {
                arr[i] = 'X';
                delOne--;
            }
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == '0' && delZero > 0) {
                arr[i] = 'X';
                delZero--;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 'X') {
                System.out.print(arr[i] + "");
            }
        }

    }

}