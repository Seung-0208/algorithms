#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int solution(int n, vector<vector<int>> results) {
    vector<vector<int>> winsInfo(n+1, vector<int>(n+1, 0));
    vector<int> wins(n+1, 0);
    vector<int> loses(n+1, 0);
    for(vector<int> r : results) {
        winsInfo[r[0]][r[1]] = 1;
        wins[r[0]]++;
        loses[r[1]]++;
    }
    
    for(int k=1; k<=n; k++) {
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(winsInfo[i][k]==1 && winsInfo[k][j]==1 && winsInfo[i][j] == 0) {
                    winsInfo[i][j] = 1;
                    wins[i]++;
                    loses[j]++;
                }
            }
        }
    }
    
    int answer = 0;
    
    for(int i=1; i<=n; i++) {
        if(wins[i]+loses[i] == n-1) answer++;
    }
    
    return answer;
}