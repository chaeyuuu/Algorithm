#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

struct Node{
    string word;
    int count;
};


bool canConvert(const string& s1, const string& s2){
    int diff = 0;
    for(int i=0; i<s1.size();i++){
        if(s1[i] != s2[i]) diff ++;
    }
    return diff == 1;
}


int bfs(string begin, string target, vector<string> words){
    queue<Node> queue;
    queue.push({begin, 0});
    
    vector<bool> visited(words.size(), false);
    
    while(!queue.empty()){
        Node now = queue.front();
        queue.pop();
        
        if(now.word == target) return now.count;
        for(int i=0; i<words.size();i++){
            if(!visited[i] && canConvert(words[i], now.word)){
                visited[i] = true;
                queue.push({words[i], now.count+1});
            }
        }
        
    }
    
}

int solution(string begin, string target, vector<string> words) {
    int answer = 0;
    
    bool isFlag = false;
    for(string word: words){
        if(word == target){
            isFlag = true;
            break;
        }
    }
    
    if(!isFlag) return 0;
    else return bfs(begin, target, words);
}
