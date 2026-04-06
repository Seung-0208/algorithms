#include <iostream>
#include <bits/stdc++.h>
#include <climits>
using namespace std;

int main() {

    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;

    vector<vector<long long>> graph(n+1, vector<long long>(n+1, LONG_LONG_MAX));

    for(int i=0; i<m; i++) {
        int a, b, c;
        cin >> a >> b >> c;
        if(graph[a][b] > c) graph[a][b] = c;
    }

    for(int i=1; i<=n; i++) graph[i][i] = 0;

    for(int k=1; k<=n; k++) {
        for(int s=1; s<=n; s++) {
            for(int e=1; e<=n; e++) {
                if(
                    graph[s][k] != LONG_LONG_MAX && graph[k][e] != LONG_LONG_MAX &&
                    graph[s][e] > graph[s][k] + graph[k][e]
                ) {
                    graph[s][e] = graph[s][k] + graph[k][e];
                }
            }
        }
    }

    for(int i=1; i<=n; i++) {
        for(int j=1; j<=n; j++) {
            if(graph[i][j] == LONG_LONG_MAX) cout << 0 << " ";
            else cout << graph[i][j] << " ";
        }
        cout << "\n";
    }


    return 0;
}