#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int toSec(string time){
    int mm = stoi(time.substr(0,2));
    int ss = stoi(time.substr(3,2));
    return mm*60+ss;
}

string solution(string video_len, string pos, string op_start, string op_end, vector<string> commands) {
    string answer = "";
    
    int videoSeconds = toSec(video_len);
    int posSeconds = toSec(pos);
    int opStartSeconds = toSec(op_start);
    int opEndSeconds = toSec(op_end);
    
    // 오프닝 범위 확인
    if(posSeconds >= opStartSeconds && posSeconds<=opEndSeconds){
        posSeconds = opEndSeconds;
    }
    
    for(const auto& command:commands){
        if(command == "next"){
            if(posSeconds + 10 > videoSeconds){
                posSeconds = videoSeconds;
             } else {
                posSeconds += 10;
            }   
        } else if (command == "prev"){
            if(posSeconds - 10 < 0){
                posSeconds = 0;
             } else {
                posSeconds -= 10;
            }   
        }
        
        if(posSeconds >= opStartSeconds && posSeconds<=opEndSeconds){
        posSeconds = opEndSeconds;
        }
    }
    
    // 파싱해야댐
    int m = posSeconds / 60;
    int s = posSeconds % 60;
    
    string mm = (m<10 ? "0" : "") + to_string(m);
    string ss = (s<10 ? "0" : "") + to_string(s);
    
    
    return mm + ":" + ss;
}