package 그리디;

import java.util.*;
import java.io.*;

public class boj1946 {

    static class Score implements Comparable<Score> {
        int docScore;
        int interviewScore;

        public Score(int docScore, int interviewScore) {
            this.docScore = docScore;
            this.interviewScore = interviewScore;
        }

        // 오름차순 정렬
        @Override
        public int compareTo(Score other) {
            return this.docScore - other.docScore;
        }
    }

    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            List<Score> scores = new ArrayList<>();

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());

                int docScore = Integer.parseInt(st.nextToken());
                int interviewScore = Integer.parseInt(st.nextToken());

                scores.add(new Score(docScore, interviewScore));
            }

            Collections.sort(scores);

            int count = 1;
            int minRank = scores.get(0).interviewScore;
            for (int j = 1; j < N; j++) {
                int curRank = scores.get(j).interviewScore;
                if (curRank < minRank) {
                    count++;
                    minRank = curRank;
                }
            }
            System.out.println(count);
        }
    }
}
