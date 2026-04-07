#include<vector>
#include <bits/stdc++.h>

using namespace std;


int n,m;
bool visited[101][101];
int dx[] = {1, 0, -1, 0};
int dy[] = {0, 1, 0, -1};

void bfs(int x, int y, vector<vector<int>>& maps){
    queue<pair<int, int>> queue;
    queue.push({y,x});
    visited[y][x] = true;
    
    while(!queue.empty()){
        pair<int, int> now = queue.front();
        queue.pop();

        int curY = now.first;
        int curX = now.second;
        
        for(int i=0; i<4; i++){
            int nextY = curY + dy[i];
            int nextX = curX + dx[i];
            
            if(nextY<n && nextY>=0 && nextX>=0 && nextX<m){
                if(!visited[nextY][nextX] && maps[nextY][nextX]==1){
                    visited[nextY][nextX] = true;
                    queue.push({nextY, nextX});
                    maps[nextY][nextX] = maps[curY][curX] + 1;
                }
            }
        }
        
        
    }
    
}

int solution(vector<vector<int>> maps)
{
    int answer = 0;
    n = maps.size();
    m = maps[0].size();
    
    memset(visited, false, sizeof(visited));
    
    // x,y로 보냄
    bfs(0,0,maps);
    
    if(maps[n-1][m-1]==1){
        return -1;
    } else{
        return maps[n-1][m-1];
    }
    
}