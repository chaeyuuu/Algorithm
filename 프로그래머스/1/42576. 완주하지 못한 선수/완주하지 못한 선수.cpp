#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    string answer = "";
    unordered_map<string, int> people;
    
    for(string part : participant){
        people[part]++;
    }
    
    for(int i=0; i<completion.size();i++){
        if(people[completion[i]]>0){
            people[completion[i]]--;
        }
    }
    
    for(auto p: people){
        if(p.second!=0){
            answer = p.first;
            break;
        }
    }
    return answer;
}