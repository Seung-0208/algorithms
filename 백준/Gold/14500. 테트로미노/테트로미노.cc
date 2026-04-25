#include <iostream>
#include <bits/stdc++.h>
#include <climits>

using namespace std;

vector<vector<int>> board;
vector<vector<int>> guide = {{1,-1,0,0}, {0,0,1,-1}};
vector<vector<bool>> isVisited;

int ans = INT_MIN;
int N, M;

void backtracking(int cnt, int sum, int r, int c) {
    if(cnt == 4) {
        if(ans < sum) ans = sum;
        return;
    }

    for(int i=0; i<4; i++) {
        int nr = r + guide[0][i];
        int nc = c + guide[1][i];

        if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
        if(isVisited[nr][nc]) continue;

        isVisited[nr][nc] = true;
        backtracking(cnt+1, sum+board[nr][nc], nr, nc);
        isVisited[nr][nc] = false;
    }
}

void middleTracking(int r, int c) {
    int smallest = INT_MAX;
    int sum = board[r][c];
    int cnt = 0;

    for(int i=0; i<4; i++) {
        int nr = r+guide[0][i];
        int nc = c+guide[1][i];

        if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
        cnt++;
        if(smallest > board[nr][nc]) smallest = board[nr][nc];
        sum += board[nr][nc];
    }

    if(cnt == 3) {
        if(ans < sum) ans = sum;
    }
    if(cnt == 4) {
        sum -= smallest;
        if(ans < sum) ans = sum;
    }
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
            backtracking(1, board[i][j], i, j);
            isVisited[i][j] = false;
            middleTracking(i, j);
        }
    }

    cout << ans << endl;

    return 0;
}