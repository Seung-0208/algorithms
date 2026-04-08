#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int main() {

    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    string line1, line2;
    cin >> line1 >> line2;

    vector<vector<int>> dp(line1.size()+1, vector<int>(line2.size()+1, 0));

    for(int i=1; i<=line1.size(); i++) {
        for(int j=1; j<=line2.size(); j++) {
            if(line1[i-1] == line2[j-1]) {
                dp[i][j] = dp[i-1][j-1]+1;
            } else {
                if(dp[i-1][j] < dp[i][j-1]) dp[i][j] = dp[i][j-1];
                else dp[i][j] = dp[i-1][j];
            }
        }
    }

    cout << dp[line1.size()][line2.size()] << endl;

    return 0;
}