package 구현;

import java.util.*;
import java.io.*;

public class boj10431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int P = Integer.parseInt(br.readLine());
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());

            int count = 0;
            List<Integer> line = new ArrayList<>();

            for (int j = 0; j < 20; j++) {
                int next = Integer.parseInt(st.nextToken());
                int insertIndex = line.size();
                boolean flag = false;

                // 자기 앞에 자기보다 큰 학생 없으면 그냥 그 자리에 서기
                // 자기 앞에 있으면 키가 큰 학생이 있으면 그 중 가장 앞에 있는 애 a 앞에 섬
                // a 뒤에 있는 애들은 한 발씩 물러섬
                for (int k = 0; k < line.size(); k++) {
                    if (line.get(k) > next) {
                        // 자기 앞에 있으면 키가 큰 학생이 있으면 그 중 가장 앞에 있는 애 a 앞에 섬
                        insertIndex = k;
                        flag = true;
                        break;
                    }
                }

                if (flag) {
                    // insertTindex 기준으로 뒤에 애들이 한 발자국씩 밀려남
                    int step = line.size() - insertIndex;
                    count += step;
                }
                line.add(insertIndex, next);
            }
            result.add(i, count);
        }

        for (int i = 0; i < P; i++) {
            System.out.println((i + 1) + " " + (result.get(i)));
        }
    }
}
