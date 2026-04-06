#include <string>
#include <vector>

using namespace std;

string solution(vector<string> cards1, vector<string> cards2, vector<string> goal) {
    string answer = "";
    
    int card1Index = 0;
    int card2Index = 0;
    
    for(int i=0; i<goal.size();i++){
        if( card1Index < cards1.size() && goal[i] == cards1[card1Index]){
            card1Index++;
        } else if (card2Index < cards2.size() &&  goal[i] == cards2[card2Index]){
            card2Index++;
        } else {
            return "No";
        }
    }
    
    return "Yes";
}