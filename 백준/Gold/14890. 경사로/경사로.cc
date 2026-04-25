#include <iostream>
#include <bits/stdc++.h>
#include <cmath>

using namespace std;

bool isRoad(vector<int>& row, int length) {
    vector<bool> isUsed(row.size(), false);

    for(int i=1; i<row.size(); i++) {
        
        if(abs(row[i]-row[i-1]) > 1) return false;
        if(row[i-1] == row[i]-1) {
            if(i-length < 0) return false;
            for(int j=i-length; j<=i-1; j++) {
                if(row[j] != row[i-1]) return false;
                if(isUsed[j]) return false;
                isUsed[j] = true;
            }
        }
    }

    for(int i=row.size()-2; i>=0; i--) {
        if(abs(row[i]-row[i+1]) > 1) return false;
        if(row[i+1] == row[i]-1) {
            if(i+length >= row.size()) return false;
            for(int j=i+1; j<=i+length; j++) {
                if(row[j] != row[i+1]) return false;
                if(isUsed[j]) return false;
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

    vector<vector<int>> map(N, vector<int>(N, 0));

    for(int i=0; i<N; i++) {
        for(int j=0; j<N; j++) {
            cin >> map[i][j];
        }
    }

    int ans = 0;
    for(int i=0; i<N; i++) {
        vector<int> temp(N, 0);
        for(int j=0; j<N; j++) {
            temp[j] = map[i][j];
        }
        if(isRoad(temp, L)) ans++;
    }

    for(int i=0; i<N; i++) {
        vector<int> temp(N, 0);
        for(int j=0; j<N; j++) {
            temp[j] = map[j][i];
        }
        if(isRoad(temp, L)) ans++;
    }

    cout << ans << endl;

    return 0;
}