#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int main() {

    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    string line1, line2, line3;
    cin >> line1 >> line2 >> line3;

    int N = line1.size();
    int M = line2.size();
    int K = line3.size();

    vector<vector<vector<int>>> dp(N+1, vector<vector<int>>(M+1, vector<int>(K+1, 0)));

    for(int i=1; i<=N; i++) {
        for(int j=1; j<=M; j++) {
            for(int k=1; k<=K; k++) {
                if(line1[i-1] == line2[j-1] && line1[i-1] == line3[k-1]) {
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

    cout << dp[N][M][K] << endl;
    

    return 0;
}