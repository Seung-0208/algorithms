#include <iostream>
#include <bits/stdc++.h>
#include <climits>
#include <cmath>

using namespace std;

vector<vector<int>> parent;
vector<int> depth;
vector<vector<int>> graph;

void initialize(int N) {
    vector<bool> isVisited(N+1, false);
    queue<int> q;
    q.push(1);
    isVisited[1] = true;

    int level = 1;
    int cnt = 0;
    int childCnt = 1;

    while(!q.empty()) {
        int cur = q.front();
        q.pop();

        cnt++;
        depth[cur] = level;

        for(int child : graph[cur]) {
            if(!isVisited[child]) {
                q.push(child);
                parent[0][child] = cur;
                isVisited[child] = true;
            }
        }

        if(cnt == childCnt) {
            level++;
            cnt = 0;
            childCnt = q.size();
        }
    }
}

long long pow(int a, int b) {
    long long x = 1;
    for(int i=1; i<=b; i++) {
        x *= a;
    }
    return x;
}

int getLCA(int a, int b, int k) {
    if(depth[a] < depth[b]) {
        int temp = a;
        a = b;
        b = temp;
    }

    for(int t=k; t>=0; t--) {
        if(pow(2, t) <= abs(depth[a]-depth[b])) {
            a = parent[t][a];
        }
    }

    for(int t=k; t>=0; t--) {
        if(parent[t][a] != parent[t][b]) {
            a = parent[t][a];
            b = parent[t][b];
        }
    }

    if(a != b) {
        a = parent[0][a];
    }
    return a;
}

int main() {

    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;

    depth.assign(N+1, 0);
    graph.assign(N+1, vector<int>());

    int k = 1, temp = 2;
    while(temp <= N) {
        temp *= 2;
        k++;
    }
    parent.assign(k+1, vector<int>(N+1, 0));

    for(int i=0; i<N-1; i++) {
        int a, b;
        cin >> a >> b;
        graph[a].push_back(b);
        graph[b].push_back(a);
    }

    initialize(N);

    for(int t = 1; t<=k; t++) {
        for(int i=1; i<=N; i++) {
            parent[t][i] = parent[t-1][parent[t-1][i]];
        }
    }

    int M;
    cin >> M;

    vector<int> ans;

    for(int i=0; i<M; i++) {
        int a, b;
        cin >> a >> b;
        
        cout << getLCA(a, b, k) << "\n";
    }


    return 0;
}