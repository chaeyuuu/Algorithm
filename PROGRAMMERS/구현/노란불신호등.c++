#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(vector<vector<int>> signals) {
    
    int n = signals.size();
    // cout << n;
    
    vector<int> totalCycle(n);
    for(int i=0; i<n;i++){
        totalCycle[i] = signals[i][0] +  signals[i][1] + signals[i][2];
    }
    
    for(int t=1; t<10000000;t++){
        bool allYellow = true;
        
        for(int j=0; j<n;j++){
            int green = signals[j][0];
            int yellow = signals[j][1];
            int total = totalCycle[j];
            
            int currentTime = (t-1) % total;
            if(!(currentTime < green+yellow && currentTime >= green)){
                allYellow = false;
                break;
            }
        }
        if(allYellow) return t;
    }
    
    
    
    return -1;
}