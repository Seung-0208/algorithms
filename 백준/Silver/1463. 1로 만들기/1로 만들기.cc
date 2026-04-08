#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int main() {

    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;

    vector<int> dp(N+1, 0);
    
    if(N==1) {
        cout << 0 << endl;
        return 0;
    }

    dp[1] = 0;

    for(int i=2; i<=N; i++) {
        dp[i] = dp[i-1]+1;
        if(i%2 == 0 && dp[i] > dp[i/2]+1) dp[i] = dp[i/2]+1;
        if(i%3 == 0 && dp[i] > dp[i/3]+1) dp[i] = dp[i/3]+1;
    }

    cout << dp[N] << endl;

    return 0;
}