#include <iostream>
#include <bits/stdc++.h>
#include <climits>

using namespace std;

vector<vector<int>> board;
vector<vector<int>> guide = {{1,-1,0,0}, {0,0,1,-1}};
int N;
int usedTime = 0;

struct CMP {
    bool operator() (pair<int, int> A, pair<int, int> B) const {
        if(A.first != B.first) return A.first > B.first;
        return A.second > B.second;
    }
};

pair<int, int> getNext(int size, int r, int c) {
    priority_queue<pair<int, int>, vector<pair<int, int>>, CMP> pq;
    queue<pair<int, int>> q;
    vector<vector<bool>> isVisited(N, vector<bool>(N, false));
    vector<vector<int>> dist(N, vector<int>(N, 0));
    q.push({r, c});
    isVisited[r][c] = true;
    int smallDist = INT_MAX;

    while(!q.empty()) {
        pair<int, int> curr = q.front();
        q.pop();

        int cr = curr.first;
        int cc = curr.second;

        for(int i=0; i<4; i++) {
            int nr = cr + guide[0][i];
            int nc = cc + guide[1][i];

            if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
            if(isVisited[nr][nc]) continue;

            if(board[nr][nc] == size || board[nr][nc] == 0) {
                dist[nr][nc] = dist[cr][cc] + 1;
                q.push({nr, nc});
                isVisited[nr][nc] = true;
            }

            else if(board[nr][nc] < size) {
                dist[nr][nc] = dist[cr][cc] + 1;
                q.push({nr, nc});
                isVisited[nr][nc] = true;

                if(smallDist > dist[nr][nc]) {
                    smallDist = dist[nr][nc];
                    while(!pq.empty()) pq.pop();
                }

                if(smallDist == dist[nr][nc]) pq.push({nr, nc});
            }
        }
    }


    if(!pq.empty()) {
        usedTime = smallDist;
        return pq.top();
    }
    return {-1, -1};

}

int main() {

    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N;

    board.assign(N, vector<int>(N, 0));

    int sr, sc;

    for(int i=0; i<N; i++) {
        for(int j=0; j<N; j++) {
            cin >> board[i][j];
            if(board[i][j] == 9) {
                sr = i;
                sc = j;
                board[i][j] = 0;
            }
        }
    }

    int size = 2;
    int cnt = 0;
    int ans = 0;
    while(1) {
        pair<int, int> next = getNext(size, sr, sc);
        if(next.first == -1) break;
        cnt++;
        ans += usedTime;
        sr = next.first;
        sc = next.second;
        board[next.first][next.second] = 0;
        if(cnt == size) {
            cnt = 0;
            size++;
        }
    }

    cout << ans << endl;

    return 0;
}