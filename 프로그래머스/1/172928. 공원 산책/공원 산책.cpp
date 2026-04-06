#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

vector<int> solution(vector<string> park, vector<string> routes) {
    vector<int> answer;
    
    int height = park.size();
    int width = park[0].size();
    
    int startY = 0, startX = 0;
    
    for(int i = 0; i < height; i++) {
        for(int j = 0; j < width; j++) {
            if(park[i][j] == 'S') {
                startY = i;
                startX = j;
            }
        }
    }
    
    for(const auto& route: routes){
        stringstream ss(route);
        char dest;
        int len;
        ss >> dest >> len;
        
        int curY = startY;
        int curX = startX;
        bool isMove = true;
        
        for(int i=0; i<len;i++) {
            if(dest == 'E') curX ++;
            else if(dest == 'W') curX--;
            else if(dest == 'S') curY++;
            else if(dest == 'N') curY--;
            
            if(curX<0 || curX >=width || curY < 0 || curY >=height 
              || park[curY][curX]=='X') {
                isMove = false;
                break;
            }
            
        }
        
                
        if(isMove) {
            startY = curY;
            startX = curX;
        }
    }    
    
    return {startY, startX};
}