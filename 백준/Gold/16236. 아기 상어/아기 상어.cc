#include <iostream>
#include <bits/stdc++.h>
#include <cmath>

using namespace std;

struct CMP {
    bool operator() (pair<int, int>& a, pair<int, int>& b) {
        if(a.first != b.first) return a.first > b.first;
        return a.second > b.second;
    }
};

vector<vector<int>> board;
int N;
vector<vector<int>> guide = {{1,-1,0,0}, {0,0,1,-1}};
int ans = 0;

pair<int, int> getNextPosition(int r, int c, int size) {
    priority_queue<pair<int,int>, vector<pair<int,int>>, CMP> pq;
    queue<pair<int, int>> q;
    vector<vector<int>> dist(board.size(), vector<int>(board.size(), 0));
    vector<vector<bool>> isVisited(board.size(), vector<bool>(board.size(), false));
    int minDist = INT_MAX;
    isVisited[r][c] = true;
    q.push({r, c});

    while(!q.empty()) {
        pair<int, int> curr = q.front();
        q.pop();

        for(int i=0; i<4; i++) {
            int nr = curr.first + guide[0][i];
            int nc = curr.second + guide[1][i];

            if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
            if(isVisited[nr][nc]) continue;
            
            isVisited[nr][nc] = true;
            dist[nr][nc] = dist[curr.first][curr.second] + 1;

            //먹을 수 있는 물고기
            if(board[nr][nc] > 0 && board[nr][nc] < size) {
                if(minDist == dist[nr][nc]) {
                    pq.push({nr, nc});
                } else if(minDist > dist[nr][nc]) {
                    pq = priority_queue<pair<int,int>, vector<pair<int,int>>, CMP>();
                    minDist = dist[nr][nc];
                    pq.push({nr, nc});
                }
            }

            if(board[nr][nc] == 0 || board[nr][nc] == size) {
                q.push({nr, nc});
            }
        }
    }

    if(pq.empty()) return {-1, -1};
    ans += minDist;
    return pq.top();
}

int main() {

    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N;

    board.assign(N, vector<int>(N, 0));
    int startR, startC;
    for(int i=0; i<N; i++) {
        for(int j=0; j<N; j++) {
            cin >> board[i][j];
            if(board[i][j] == 9) {
                startR = i;
                startC = j;
                board[i][j] = 0;
            }
        }
    }

    int size = 2;
    int cnt = 0;

    while(1) {
        pair<int, int> next = getNextPosition(startR, startC, size);
        if(next.first == -1) {
            break;
        }
        cnt++;
        if(cnt == size) {
            size++;
            cnt = 0;
        }
        startR = next.first;
        startC = next.second;
        board[startR][startC] = 0;
    }

    cout << ans << endl;

    return 0;
}