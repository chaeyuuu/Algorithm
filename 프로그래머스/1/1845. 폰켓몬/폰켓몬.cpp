#include <vector>
#include <bits/stdc++.h>
using namespace std;

int solution(vector<int> nums)
{
    unordered_map<int,int> map;
    
    for(int i=0; i<nums.size();i++){
        map[nums[i]]++;
    }
    
    int answer = min(nums.size()/2 , map.size());
    
    return answer;
}