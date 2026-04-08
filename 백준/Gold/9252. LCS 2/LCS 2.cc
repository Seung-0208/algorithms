#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int main() {

    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    string line1, line2;
    cin >> line1 >> line2;

    int N = line1.size();
    int M = line2.size();

    vector<vector<int>> dp(N+1, vector<int>(M+1, 0));
    
    for(int i=1; i<=N; i++) {
        for(int j=1; j<=M; j++) {
            if(line1[i-1]==line2[j-1]) {
                dp[i][j] = dp[i-1][j-1]+1;
            }
            else {
                if(dp[i-1][j] < dp[i][j-1]) dp[i][j] = dp[i][j-1];
                else dp[i][j] = dp[i-1][j];
            }
        }
    }

    cout << dp[N][M] << "\n";

    if(dp[N][M] > 0) {
        int i=N, j=M;
        vector<char> ans(dp[N][M]);
        int idx = dp[N][M]-1;
        while(i-1>=0 && j-1>=0) {
            if(i-1>=0 && j-1>=0 && line1[i-1] == line2[j-1] && idx >= 0) {
                ans[idx] = line1[i-1];
                i--; j--;
                idx--;
            }
            else if(dp[i-1][j] <= dp[i][j-1]) {
                j--;
            } else {
                i--;
            }
        }

        for(char c : ans) {
            cout << c;
        }
        cout << endl;
    }

    return 0;
}