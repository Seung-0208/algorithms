#include <iostream>
#include <bits/stdc++.h>

using namespace std;

bool calculate(vector<int> line, int N, int L) {
    vector<bool> isUsed(N, false);

    for(int i=0; i<N-1; i++) {
        int cur = line[i];
        int next = line[i+1];

        if(cur==next) continue;
        if(cur-next >= 2 || cur-next <= -2) return false;

        if(cur < next) {
            if(i+1-L < 0) return false;
            for(int j=i; j>=i+1-L; j--) {
                if(line[j] != cur) return false;
                if(isUsed[j]) return false;
            }
            for(int j=i; j>=i+1-L; j--) {
                isUsed[j] = true;
            }
        }

        if(cur > next) {
            if(i+L >= N) return false;
            for(int j=i+1; j<=i+L; j++) {
                if(line[j] != next) return false;
                if(isUsed[j]) return false;
            }
            for(int j=i+1; j<=i+L; j++) {
                isUsed[j] = true;
            }
        }
    }

    return true;
}

int main() {

    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, L;
    cin >> N >> L;

    vector<vector<int>> board(N, vector<int>(N, 0));

    for(int i=0; i<N; i++) {
        for(int j=0; j<N; j++) {
            cin >> board[i][j];
        }
    }

    int cnt = 0;

    for(int i=0; i<N; i++) {
        vector<int> temp(N, 0);
        for(int j=0; j<N; j++) {
            temp[j] = board[i][j];
        }
        if(calculate(temp, N, L)) cnt++;
    }

    for(int i=0; i<N; i++) {
        vector<int> temp(N, 0);
        for(int j=0; j<N; j++) {
            temp[j] = board[j][i];
        }
        if(calculate(temp, N, L)) cnt++;
    }

    cout << cnt << endl;

    return 0;
}