#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);

    int people,party;
    cin >> people >> party;

    int truthNum;
    cin >> truthNum;

    // bool 형으로 초기화하고 사람수만큼 false로 기본 초기화
    vector<bool> truths(people+1, false);

    for(int i=0; i<truthNum;i++){
        int p;
        cin >> p;
        truths[p] = true;
    }

    vector<vector<int>> parties(party);
    for(int i=0; i<party;i++){
        // 파티의 개수만큼 돌기
        // 첫 번째가 해당 파티에 참여하는 사람의 수
        int num;
        cin>>num;

        // 해당 파티의 멤버만큼 푸쉬
        for(int j=0; j<num;j++){
            int member;
            cin >> member;
            parties[i].push_back(member);
        }
    }

    // 해당 파티에 진실아는사람 있는지 확인해보기
    // 있으면 해당 파티에 참여한 다른 사람도 진실 아는 사람에 포함
    // 진실 전파의 시간
    while(true){
        bool isUpdate = false;

        for(int i=0; i<party;i++){
        bool containTrue = false;
        for(int member: parties[i]){
            if(truths[member]){
                containTrue = true;
            }
        }

        if(containTrue){
            for(int member: parties[i]){
                if(!truths[member]){
                    truths[member] = true;
                    isUpdate = true;
                }

                }
            }
       }

       if(!isUpdate) break;
    }

    int count = 0;
    for(int i=0; i<party; i++){
        bool canCount = true;
        for(int member: parties[i]){
            if(truths[member]){
                // true라면
                canCount = false;
                break;

            } 
        }

        if(canCount) count++;
    }

    cout << count << endl;

    return 0;
}