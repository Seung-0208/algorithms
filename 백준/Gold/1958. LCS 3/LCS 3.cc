#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int main() {

    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string line1, line2, line3;

    cin >> line1 >> line2 >> line3;

    int len1 = line1.size();
    int len2 = line2.size();
    int len3 = line3.size();

    vector<vector<vector<int>>> dp(len1+1, vector<vector<int>>(len2+1, vector<int>(len3+1, 0)));

    for(int i=1; i<=len1; i++) {
        for(int j=1; j<=len2; j++) {
            for(int k=1; k<=len3; k++) {
                if(line1[i-1]==line2[j-1] && line2[j-1]==line3[k-1]) {
                    dp[i][j][k] = dp[i-1][j-1][k-1] + 1;
                } else {
                    int temp = dp[i-1][j][k];
                    if(temp < dp[i][j-1][k]) temp = dp[i][j-1][k];
                    if(temp < dp[i][j][k-1]) temp = dp[i][j][k-1];
                    dp[i][j][k] = temp;
                }
            }
        }
    }
    
    cout << dp[len1][len2][len3] << endl;

    return 0;
}