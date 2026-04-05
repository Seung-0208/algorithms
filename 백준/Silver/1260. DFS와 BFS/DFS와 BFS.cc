#include <iostream>
#include <bits/stdc++.h>

using namespace std;

vector<vector<int>> graph;
vector<bool> isVisited;
void DFS(int node) {
    isVisited[node] = true;
    cout << node << " ";
    for(int next : graph[node]) {
        if(!isVisited[next]) DFS(next);
    }
}

void BFS(int node) {
    queue<int> q;
    q.push(node);
    isVisited[node] = true;
    
    while(!q.empty()) {
        int cur = q.front();
        q.pop();

        cout << cur << " ";
        for(int next : graph[cur]) {
            if(!isVisited[next]) {
                isVisited[next] = true;
                q.push(next);
            }
        }
    }
}

int main() {

    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, M, V;
    cin >> N >> M >> V;

    graph.assign(N+1, vector<int>());
    isVisited.assign(N+1, false);
    for(int i=0; i<M; i++) {
        int a, b;
        cin >> a >> b;
        graph[a].push_back(b);
        graph[b].push_back(a);
    }

    for(int i=1; i<=N; i++) {
        sort(graph[i].begin(), graph[i].end());
    }

    DFS(V);
    cout << "\n";
    isVisited.assign(N+1, false);
    BFS(V);

    return 0;
}