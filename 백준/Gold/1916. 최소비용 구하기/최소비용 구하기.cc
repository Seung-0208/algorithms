#include <iostream>
#include <bits/stdc++.h>
#include <climits>
using namespace std;

struct Node {
    int end, weight;
};

struct CMP {
    bool operator()(const Node& a, const Node&b) const {
        return a.weight > b.weight;
    }
};

int N;
vector<vector<Node>> graph;
vector<int> dist;

void dijkstar(int start) {
    dist[start] = 0;
    vector<bool> isVisited(N+1, false);
    priority_queue<Node, vector<Node>, CMP> q;
    q.push({start, 0});

    while (!q.empty()) {
        Node cur = q.top();
        q.pop();

        if(isVisited[cur.end]) continue;
        isVisited[cur.end] = true;

        for(Node next : graph[cur.end]) {
            if(!isVisited[next.end] && dist[next.end] > dist[cur.end]+next.weight) {
                dist[next.end] = dist[cur.end]+next.weight;
                q.push({next.end, dist[next.end]});
            }
        }
    }
}

int main() {

    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int M;
    cin >> N >> M;

    graph.assign(N+1, vector<Node>());
    dist.assign(N+1, INT_MAX);

    for(int i=0; i<M; i++) {
        int s, e, w;
        cin >> s >> e >> w;
        graph[s].push_back({e, w});
    }

    int start, end;
    cin >> start >> end;

    dijkstar(start);

    cout << dist[end] << endl;

    return 0;
}