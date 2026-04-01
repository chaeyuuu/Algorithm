import java.io.*;
import java.util.*;

public class boj21921 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int day = Integer.parseInt(st.nextToken()); // 블로그 시작하고 지난 일수 N
        int X = Integer.parseInt(st.nextToken()); // X일동안 가장 많이 들어온 방문자 수

        int[] dayArr = new int[day];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < dayArr.length; i++) {
            dayArr[i] = Integer.parseInt(st.nextToken());
        }

        // 슬라이딩 윈도우로 할 때

        // 첫 기간 값 저장해놓기
        int ans = 0;
        int count = 0;
        for (int i = 0; i < X; i++) {
            count += dayArr[i];
        }

        ans = count; // 현재 가장 큰 값임
        int totalCount = 1; // 최댓값 수
        // 이제 남은 부분 슬라이딩 윈도우로 계산해보기
        for (int i = 0; i < dayArr.length; i++) {

            count -= dayArr[i];

            if (i + X < dayArr.length) {
                int nextIndex = i + X;
                count += dayArr[nextIndex];
            }

            if (count != 0 && ans < count) {
                // 최댓값 갱신이니까 1해줌
                totalCount = 1;
            } else if (ans == count) {
                // 기존 최댓값이랑 똑같은 값이면 값 증가
                totalCount++;
            }

            // System.out.println("max전 count: " + count + ", ans: " + ans + ", totalCount:
            // " + totalCount);

            ans = Math.max(ans, count);

            // System.out.println("max후 count: " + count + ", ans: " + ans + ", totalCount:
            // " + totalCount);

        }

        if (ans == 0) {
            System.out.println("SAD");
            return;
        } else {
            System.out.println(ans);
            System.out.println(totalCount);
        }

    }

}
