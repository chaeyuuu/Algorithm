import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 이전에 나왔던 단어가 떨어져서 나오면 안됨
        int N = Integer.parseInt(br.readLine());

        int result = 0;
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            boolean[] visited = new boolean[26];
            boolean isGroupWord = true;
            // 단어 하나에서
            // ex) aba임
            for (int j = 0; j < word.length(); j++) {
                int now = word.charAt(j) - 'a'; // 이러면 알파벳을 숫자로
                // 만약에 돌았는데 이전에 방문한 알파벳인지 확인해야함
                if (visited[now]) {
                    // 방문한거면!! 그룹알파벳에서 빼고 이거
                    isGroupWord = false; // 그룹알파벳이 아니라는거심
                    break;
                }

                // 일단 이미 나온 알파벳이라고 표시
                // a가 나옴
                visited[now] = true; // 어케 표현해야할진 머르겠음 ㅎ j번째 알파벳인데 ..

                // 이제 이 알파벳이 연속된건지 확인해보기
                // 지금 알파벳이랑 다음이 같으면 (범위도 확인)
                if (j + 1 < word.length() && word.charAt(j) == word.charAt(j + 1)) {
                    // 계속 같은 알파벳인 부분까지 길이 증가
                    while (j + 1 < word.length() && word.charAt(j) == word.charAt(j + 1)) {
                        j++;
                    }
                }

                // 처음 나온 알파벳부터 그 알파벳이랑 같은 곳까지 다 돌았으면 그룹 알파벳에 추가
                // visited[] 가 true면 !!
                // i가 아닌데.. 아무튼 일단 추가

                // }
            }

            if (isGroupWord) {
                result++;
            }

        }

        System.out.println(result);

    }

}
