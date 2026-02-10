package 구현;

import java.util.*;
import java.io.*;

public class boj20125 {
        public static void main(String[] args) throws IOException {
                // 심장은 머리 바로 아래에 있음
                // 심장 기준으로 왼쪽, 오른쪽,
                // 처음 * 나온거에다가 + 1 한게 심장위치
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                int N = Integer.parseInt(br.readLine());
                char[][] cookie = new char[N][N];

                int headX = -1, headY = -1;
                int leftArm = 0, rightArm = 0, leftLeg = 0, rightLeg = 0;
                int waist = 0;

                boolean isFound = false;

                for (int i = 0; i < N; i++) {
                        // i가 행(x)
                        String line = br.readLine();
                        for (int j = 0; j < N; j++) {
                                // j가 열(y)
                                cookie[i][j] = line.charAt(j);
                                if (cookie[i][j] == '*' && isFound == false) {
                                        headX = i + 1;
                                        headY = j;
                                        isFound = true;
                                }
                        }
                }

                // 왼쪽 팔
                int curY = headY - 1;
                while (curY >= 0 && cookie[headX][curY] == '*') {
                        leftArm++;
                        curY--;
                }

                // 오른쪽 팔
                curY = headY + 1;
                while (curY < N && cookie[headX][curY] == '*') {
                        rightArm++;
                        curY++;
                }

                // 허리
                int curX = headX + 1;
                while (curX < N && cookie[curX][headY] == '*') {
                        waist++;
                        curX++;
                }

                // 왼쪽 다리
                curX = headX + waist + 1;
                while (curX < N && cookie[curX][headY - 1] == '*') {
                        curX++;
                        leftLeg++;
                }

                // 오른쪽 다리
                curX = headX + waist + 1;
                while (curX < N && cookie[curX][headY + 1] == '*') {
                        curX++;
                        rightLeg++;
                }

                System.out.println((headX + 1) + " " + (headY + 1));
                System.out.println(leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);
        }
}
