#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);


    int N;
    cin >> N;

    int result = 0;
    for(int i=0; i<N;i++){
        string word;
        cin >> word;
        bool visited [26] = {false};
        bool isGroup = true;
        for(int j=0; j<word.size(); j++){
            int now = word[j] - 'a';

            if(visited[now]){
                isGroup = false;
                break;
            }

            // 방문했다고 표시
            visited[now] = true;
            if(j+1 < word.length() && word[j] == word[j+1]){
                while( j+1<word.length() && word[j]==word[j+1]){
                    j++;
                }
            }

        }

        if (isGroup){
            result ++;
        }
    }

    cout << result;

    return 0;

}