#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(vector<int> numbers) {
    string answer = "";
    
    vector<string> words;
    
    for(int num:numbers){
        words.push_back(to_string(num));
    }
    
    sort(words.begin(), words.end(), [](const string& a, const string& b ){
        return a+ b> b+ a;
    });
    
    for(string word: words){
        answer += word;
    }
    
    if (answer[0] == '0') return "0";
    
    return answer;
}