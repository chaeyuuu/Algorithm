#include <string>
#include <vector>
#include <bits/stdc++.h>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;
    
    for(int i=0; i<commands.size();i++){
        int start = commands[i][0];
        int end = commands[i][1];
        int index = commands[i][2];
        
        vector<int> newArr; //4만큼
        // start = 2, end = 5
        // 1,2,3,4 -> 5,2,6,3
        for(int j=start-1; j<end;j++){ // 1~5까지 1,2,3,4,
            newArr.push_back(array[j]);
        }    
        
        sort(newArr.begin(), newArr.end());
        answer.push_back(newArr[index-1]);
    }
    
    
    return answer;
}