#include <iostream>
#include <vector>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;

    vector<long long> dp(N+1);
    long long dp1[91];

    dp[1] = 1;
    if(N>=2) dp[2] = 1;

    for(int i=3; i<=N;i++){
        dp[i] = dp[i-1] + dp[i-2];
    }

    cout << dp[N];

    return 0;
}