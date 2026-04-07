import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean isFlag = false;
        for(String word: words){
            if(word.equals(target)){
                // target 단어가 words에 있으면
                isFlag = true;
                break;
            } 
        }
        
        if(!isFlag) return 0;
        else return bfs(begin, target, words);
    }
    
    static public int bfs(String begin, String target, String[] words){
        Queue<Node> queue = new LinkedList<>();
        // 단어랑 count값 저장
        queue.add(new Node(begin,0));
        
        boolean[] visited = new boolean[words.length];
        
        while(!queue.isEmpty()){
            Node now = queue.poll();
            if(now.word.equals(target)) return now.count;
            
            for (int i = 0; i < words.length; i++) {
                // 아직 방문 안 했고 + 글자가 딱 하나만 다르다면
                if (!visited[i] && canConvert(now.word, words[i])) {
                    visited[i] = true;
                    queue.add(new Node(words[i], now.count+1));
                }
            }
            
        }
        return 0;
    }
    
    static public boolean canConvert(String s1, String s2){
        int diff = 0;
        for(int i=0; i<s1.length();i++){
            if(s1.charAt(i) != s2.charAt(i)) diff +=1;
        }
        
        return diff == 1;
    }
}

class Node{
    String word;
    int count;
    
   public Node(String word, int count){
        this.word = word;
        this.count = count;
    }
}