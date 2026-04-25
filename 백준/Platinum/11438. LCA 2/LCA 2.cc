#include <iostream>
#include <bits/stdc++.h>
#include <cmath>

using namespace std;

vector<vector<int>> parent;
vector<vector<int>> graph;
vector<int> depth;
int N;
int K = 1;

void init() {
    queue<int> q;
    vector<bool> isVisited(N+1, false);
    int level = 1;
    int cnt = 0;
    int childCnt = 1;
    q.push(1);
    isVisited[1] = true;

    while(!q.empty()) {
        int cur = q.front();
        q.pop();

        depth[cur] = level;

        for(int child : graph[cur]) {
            if(!isVisited[child]) {
                q.push(child);
                isVisited[child] = true;
                parent[0][child] = cur;
            }
        }

        cnt++;

        if(childCnt == cnt) {
            cnt = 0;
            childCnt = q.size();
            level++;
        }
    }
}

int getLCA(int a, int b) {
    if(depth[a] < depth[b]) {
        int temp = a;
        a = b;
        b = temp;
    }

    for(int k=K; k>=0; k--) {
        if(pow(2, k) <= abs(depth[a] - depth[b])) {
            a = parent[k][a];
        }
    }

    for(int k=K; k>=0; k--) {
        if(parent[k][a] != parent[k][b]) {
            a = parent[k][a];
            b = parent[k][b];
        }
    }

    if(a != b) return parent[0][a];
    return a;
}


int main() {

    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N;

    int temp = 2;
    while(temp*2 <= N) {
        temp *= 2;
        K++;
    }

    parent.assign(K+1, vector<int>(N+1, 0));
    graph.assign(N+1, vector<int>());
    depth.assign(N+1, 0);

    for(int i=0; i<N-1; i++) {
        int a, b;
        cin >> a >> b;
        graph[a].push_back(b);
        graph[b].push_back(a);
    }

    init();

    for(int k=1; k<=K; k++) {
        for(int i=1; i<=N; i++) {
            parent[k][i] = parent[k-1][parent[k-1][i]];
        }
    }

    int M;
    cin >> M;

    for(int i=0; i<M; i++) {
        int a, b;
        cin >> a >> b;
        cout << getLCA(a, b) << "\n";
    }
    cout << endl;

    return 0;
}