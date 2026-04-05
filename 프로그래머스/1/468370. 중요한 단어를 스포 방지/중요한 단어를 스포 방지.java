import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int answer = 0;
        String[] words = message.split(" ");
        
        // 단어들의 시작 인덱스를 담을 배열
        int[] starts = new int[words.length];
        int curr = 0;
        for (int i = 0; i < words.length; i++) {
            starts[i] = curr;
            curr += words[i].length() + 1;
        }

        // 1. 스포일러가 아닌 구역에 등장한 단어들 찾기
        HashSet<String> safeWords = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            int wStart = starts[i];
            int wEnd = starts[i] + words[i].length() - 1;
            
            boolean isSpoiler = false;
            for (int[] range : spoiler_ranges) {
                if (!(wEnd < range[0] || wStart > range[1])) {
                    isSpoiler = true;
                    break;
                }
            }
            if (!isSpoiler) safeWords.add(words[i]);
        }

        // 2. 중요한 단어 판단 (중복 방지용 Set 하나 더)
        HashSet<String> alreadyCounted = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            int wStart = starts[i];
            int wEnd = starts[i] + words[i].length() - 1;
            
            boolean isSpoiler = false;
            for (int[] range : spoiler_ranges) {
                if (!(wEnd < range[0] || wStart > range[1])) {
                    isSpoiler = true;
                    break;
                }
            }

            if (isSpoiler) {
                // 일반 구역에 없고 + 이전에 카운트한 적 없는 스포 단어라면
                if (!safeWords.contains(words[i]) && !alreadyCounted.contains(words[i])) {
                    answer++;
                    alreadyCounted.add(words[i]);
                }
            }
        }

        return answer;
    }
}