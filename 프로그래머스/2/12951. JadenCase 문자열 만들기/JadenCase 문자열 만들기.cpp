#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

string solution(string s) {
    string answer = "";
    
    bool is_first = true;
    
    for(int i=0; i<s.length();i++){
        if(is_first){
            // 첫번째 문자면
            s[i] = toupper(s[i]);
            answer += s[i];
        } else {
            s[i] = tolower(s[i]);
            answer += s[i];
        }
        
        if(s[i] == ' '){
            is_first = true;
        } else {
            is_first = false;
        }
    }
    
    
    return answer;
}