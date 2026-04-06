#include <iostream>
#include <bits/stdc++.h>
#include <climits>
using namespace std;

struct Node {
    int start, end, time;
};

int main() {

    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, M;

    cin >> N >> M;

    vector<Node> edges;
    for(int i=0; i<M; i++) {
        int A, B, C;
        cin >> A >> B >> C;
        edges.push_back({A, B, C});
    }

    vector<long long> dist(N+1, LONG_LONG_MAX);

    dist[1] = 0;

    for(int i=0; i<N; i++) {
        for(Node n : edges) {
            if(dist[n.start] != LONG_LONG_MAX && dist[n.end] > dist[n.start] + n.time) {
                dist[n.end] = dist[n.start] + n.time;
            }
        }
    }

    bool isInfinite = false;

    for(Node n : edges) {
        if(dist[n.start] != LONG_LONG_MAX && dist[n.end] > dist[n.start] + n.time) {
            isInfinite = true;
        }
    }

    if(isInfinite) {
        cout << -1 << endl;
        return 0;
    }

    for(int i=2; i<=N; i++) {
        if(dist[i] == LONG_LONG_MAX) cout << -1 << "\n";
        else cout << dist[i] << "\n";
    }

    return 0;
}