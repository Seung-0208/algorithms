#include <iostream>
#include <bits/stdc++.h>

using namespace std;

struct Node {
    int start, end, weight;
};

struct CMP {
    bool operator()(const Node& a, const Node& b) const {
        return a.weight > b.weight;
    }
};

vector<int> parent;

int find(int a) {
    if(parent[a] == a) return a;
    return find(parent[a]);
}

void merge(int a, int b) {
    parent[a] = find(a);
    parent[b] = find(b);
    if(parent[a] != parent[b]) {
        parent[parent[a]] = parent[b];
    }
}

int main() {

    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int V, E;
    cin >> V >> E;

    priority_queue<Node, vector<Node>, CMP> q;

    for(int i=0; i<E; i++) {
        int a, b, c;
        cin >> a >> b >> c;
        q.push({a, b, c});
    }

    parent.assign(V+1, 0);
    for(int i=1; i<=V; i++) {
        parent[i] = i;
    }

    int cnt = 0;
    long long weight = 0;

    while(!q.empty()) {
        Node cur = q.top();
        q.pop();

        parent[cur.start] = find(cur.start);
        parent[cur.end] = find(cur.end);

        if(parent[cur.start] != parent[cur.end]) {
            merge(cur.start, cur.end);
            cnt++;
            weight += cur.weight;
        }

        if(cnt == V-1) break;
    }

    cout << weight << endl;

    return 0;
}