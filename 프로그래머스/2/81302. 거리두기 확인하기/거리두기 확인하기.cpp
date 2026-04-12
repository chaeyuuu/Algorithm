#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int dx[] = {1,0,-1,0};
int dy[] = {0,-1,0,1};

bool bfs(int r, int c, vector<string> place){
    bool visited[5][5] = {false, };
    queue<pair<pair<int, int>, int>> q;
    q.push({{r,c}, 0});
    visited[r][c] = true;
    
    while(!q.empty()){
        int y = q.front().first.first;
        int x = q.front().first.second;
        int dist = q.front().second;
        q.pop();
        
        if(dist < 2){
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
                if(visited[ny][nx] || place[ny][nx] == 'X') continue;
                if(place[ny][nx] == 'P') return false;
                
                visited[ny][nx] = true;
                q.push({{ny, nx}, dist+1});
            }
        }
    }
    
    return true;
}


vector<int> solution(vector<vector<string>> places) {
    vector<int> answer;
    
    for(int s=0; s<places.size(); s++){
        bool isOk = true;
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(places[s][i][j]=='P'){
                   if (!bfs(i, j, places[s])) {
                        isOk = false;
                        break;
                    }
                }
                
            }
            if(!isOk) break;
        }
        
        
        if(isOk){
             answer.push_back(1);
        } else {
            answer.push_back(0);
        }
       
    }
    
    return answer;
}