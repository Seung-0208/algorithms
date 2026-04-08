#include <iostream>
#include <bits/stdc++.h>
#include <climits>

using namespace std;

int N, M;
vector<vector<int>> board;
vector<vector<bool>> isVisited;
int guide[2][4] = {{1,-1,0,0}, {0,0,1,-1}};
int ans = INT_MIN;

void DFS(int r, int c, int depth, int sum) {
    if(depth == 4) {
        if(ans < sum) ans = sum;
        return;
    }

    for(int i=0; i<4; i++) {
        int nr = r+guide[0][i];
        int nc = c+guide[1][i];

        if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
        if(isVisited[nr][nc]) continue;

        isVisited[nr][nc] = true;
        DFS(nr, nc, depth+1, sum+board[nr][nc]);
        isVisited[nr][nc] = false;
    }
}

void calculateMiddle(int r, int c) {
    int minValue = INT_MAX;
    int sum = board[r][c];
    int cnt = 0;

    for(int i=0; i<4; i++) {
        int nr = r+guide[0][i];
        int nc = c+guide[1][i];

        if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
        if(minValue > board[nr][nc]) minValue = board[nr][nc];
        sum += board[nr][nc];
        cnt++;
    }

    if(cnt == 3 && ans < sum) {
        ans = sum;
        return;
    }
    if(cnt == 4) {
        sum -= minValue;
        if(ans < sum) ans = sum;
        return;
    }
    return;
}

int main() {

    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N >> M;
    board.assign(N, vector<int>(M, 0));
    isVisited.assign(N, vector<bool>(M, false));

    for(int i=0; i<N; i++) {
        for(int j=0; j<M; j++) {
            cin >> board[i][j];
        }
    }
    
    for(int i=0; i<N; i++) {
        for(int j=0; j<M; j++) {
            isVisited[i][j] = true;
            DFS(i, j, 1, board[i][j]); //시작점
            isVisited[i][j] = false;
            
            calculateMiddle(i, j);
        }
    }

    cout << ans << endl;
    

    return 0;
}