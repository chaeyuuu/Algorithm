package 구현;

import java.util.*;
import java.io.*;

public class boj22233 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 메모장에 적은 키워드 수
        int M = Integer.parseInt(st.nextToken()); // 블로그에 쓴 글

        Set<String> keywords = new HashSet<>(); // 메모장에 적은 키워드

        for (int i = 0; i < N; i++) {
            keywords.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            Set<String> relateds = new HashSet<>(); // 관련된 키워드

            // 쉼표로 구분 받아서 저장
            st = new StringTokenizer(br.readLine(), ",");

            while (st.hasMoreTokens()) {
                String relate = st.nextToken();
                relateds.add(relate);
            }

            keywords.removeAll(relateds);

            System.out.println(keywords.size());
        }
    }

}
