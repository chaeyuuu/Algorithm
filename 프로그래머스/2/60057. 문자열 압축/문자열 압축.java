import java.util.*;
import java.io.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        if(s.length() == 1) return 1;
        
        // s 길이 구하고
        int min = s.length();                    // 1개부터 늘려가면서 압축해보기
        for(int splitNum=1; splitNum<= (s.length() /2); splitNum++) {
            // 처음부터 list.get(i) 만큼을 기준으로 잡고
            // 기준 단어가 그 다음 i만큼 동일하면 숫자 + 해당단어
            
            ArrayList<String> wordList = new ArrayList<>();
            for(int j=0; j<s.length(); j+=splitNum){
                // j의 길이만큼의 문자열이 있음
                // splitNum만큼 그 j의 문자열을 잘라서 저장
                int endIndex = j + splitNum;
                if(endIndex > s.length()){
                    endIndex = s.length();
                }
                
                wordList.add(s.substring(j, endIndex));
                
            }
            
            StringBuilder resultWord = new StringBuilder();
            
            int count = 1;
            String nowWord = wordList.get(0);
            
            int w = 0;
            
            while(w < wordList.size()-1) {
                if (nowWord.equals(wordList.get(w+1))) {                                                   count++;
                   // w++; // 그 다음꺼는 안 봐도됨 왜냐면 같으니까
                }
                else {
                    if (count == 1){
                        resultWord.append(nowWord);
                    } else {
                        resultWord.append(count).append(nowWord);
                    }
                    nowWord = wordList.get(w+1);
                    count = 1;
                }
                
                w++;
            }
            
            // 마지막 단어 비교
             if (count == 1) {
                resultWord.append(nowWord);
            } else {
                resultWord.append(count).append(nowWord);
            }
            
            // 최소 길이 갱신
            if (min > resultWord.length()) {
                min = resultWord.length();
            }
            
        }
        
        return min;
    }
}