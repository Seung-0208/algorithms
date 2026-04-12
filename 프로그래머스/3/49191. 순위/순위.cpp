#include <string>
#include <vector>

using namespace std;

int solution(int n, vector<vector<int>> results) {
    vector<vector<bool>> isWin(n+1, vector<bool>(n+1, false));
    vector<int> winCnt(n+1, 0);
    vector<int> loseCnt(n+1, 0);
    
    for(vector<int> r : results) {
        int win = r[0];
        int lose = r[1];
        isWin[win][lose] = true;
        winCnt[win]++;
        loseCnt[lose]++;
    }
    
    for(int k=1; k<=n; k++) {
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(isWin[i][k] && isWin[k][j] && !isWin[i][j]) {
                    isWin[i][j] = true;
                    winCnt[i]++;
                    loseCnt[j]++;
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