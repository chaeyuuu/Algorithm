#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

string solution(string s) {
    stringstream ss(s);
    string temp;
    vector<int> vec;
    
    while(ss>>temp){
        vec.push_back(stoi(temp));
    }
    
    sort(vec.begin(), vec.end());
    
    string answer = to_string(vec.front()) + " " + to_string(vec.back());
    
    return answer;
}