#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int solution(int n, vector<vector<int>> results) {
    
    cout << true << "\n";
    cout << false << "\n";
    
    vector<vector<bool>> isWin(n+1, vector<bool>(n+1, false));
    vector<int> winCnt(n+1, 0);
    vector<int> loseCnt(n+1, 0);
    
    
    for(vector<int> r : results) {
        int win = r[0];
        int lose = r[1];
        winCnt[win]++;
        loseCnt[lose]++;
        isWin[win][lose] = true;
    }
    
    for(int k=1; k<=n; k++) {
        for(int s=1; s<=n; s++) {
            for(int e=1; e<=n; e++) {
                if(isWin[s][e] == false && isWin[s][k] && isWin[k][e]) {
                    isWin[s][e] = true;
                    winCnt[s]++;
                    loseCnt[e]++;
                }
            }
        }
    }
    
    int answer = 0;
    
    for(int i=1; i<=n; i++) {
        if(winCnt[i] + loseCnt[i] == n-1) answer++;
    }
    
    return answer;
}