#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

vector<string> solution(vector<string> players, vector<string> callings) {
    vector<string> answer;
    
    unordered_map<string, int> rankMap;
    
    for(int i=0; i<players.size();i++){
        rankMap[players[i]] = i;
    }
    
    for(auto& calling: callings){
        int currRank = rankMap[calling];
        int prevRank = currRank - 1;
        
        string prevPlayer = players[currRank-1];
        players[currRank] = prevPlayer;
        players[prevRank] = calling;
        
        rankMap[calling] = prevRank;
        rankMap[prevPlayer] = currRank;
        
    }
    
    return players;
}