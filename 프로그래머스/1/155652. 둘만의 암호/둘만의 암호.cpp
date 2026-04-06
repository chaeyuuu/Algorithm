#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

string solution(string s, string skip, int index) {
    string answer = "";
    
    vector<char> alpabet;
    for(char i = 'a' ; i<='z'; i++){
        if(skip.find(i) == string::npos) {
            alpabet.push_back(i);
        }
    }
    
    for(char c: s){
        int currIndex = 0;
        for(int i=0; i<alpabet.size();i++){
            if(alpabet[i] == c){
                currIndex = i;
                break;
            }
        }
        
        int nextIndex = (currIndex + index) % alpabet.size();
        answer += alpabet[nextIndex];
    }
    
    return answer;
}