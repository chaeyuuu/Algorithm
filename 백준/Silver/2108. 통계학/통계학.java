import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        double sum = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        // 산술평균 : N개의 수들의 합을 N으로 나눈 값

        System.out.println(Math.round(sum / N));

        List<Integer> listArr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            listArr.add(arr[i]);
        }

        Collections.sort(listArr);

        // 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
        int middleNum = listArr.get(N / 2);
        System.out.println(middleNum);

        // 최빈값 : N개의 수들 중 가장 많이 나타나는 값
        int mostFequently = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            mostFequently = Math.max(mostFequently, map.get(arr[i]));
        }

        List<Integer> modeList = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == mostFequently) {
                modeList.add(key);
            }
        }

        Collections.sort(modeList);
        // 최빈값이 여러개라면!!
        if (modeList.size() > 1) {
            System.out.println(modeList.get(1));
        } else {
            System.out.println(modeList.get(0));
        }
        // 범위 : N개의 수들 중 최댓값과 최솟값의 차이

        int range = listArr.get(N - 1) - listArr.get(0);
        System.out.println(range);

    }
}
