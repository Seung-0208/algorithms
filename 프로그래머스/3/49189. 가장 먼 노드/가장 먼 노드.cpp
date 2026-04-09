#include <string>
#include <vector>
#include <climits>
#include <bits/stdc++.h>

using namespace std;

vector<vector<int>> graph;
vector<int> dist;

struct Node {
    int value, weight;
};

struct CMP {
    bool operator()(Node& a, Node& b) const {
        return a.weight > b.weight;
    }
};

void dijkstra(int start, int n) {
    priority_queue<Node, vector<Node>, CMP> q;
    vector<bool> isVisited(n+1, false);
    
    //초기화
    dist[start] = 0;
    q.push({start, 0});
    
    while(!q.empty()) {
        Node cur = q.top();
        q.pop();
        
        if(isVisited[cur.value]) continue;
        isVisited[cur.value] = true;
        
        for(int child : graph[cur.value]) {
            if(!isVisited[child] && dist[child] > dist[cur.value]+1) {
                dist[child] = dist[cur.value]+1;
                q.push({child, dist[child]});
            }
        }
    }
}

int solution(int n, vector<vector<int>> edge) {
    
    graph.assign(n+1, vector<int>());
    dist.assign(n+1, INT_MAX);
    dist[0] = 0;
    
    for(vector<int> e : edge) {
        int a = e[0];
        int b = e[1];
        graph[a].push_back(b);
        graph[b].push_back(a);
    }
    
    dijkstra(1, n);
    
    int max = INT_MIN;
    int node = 0;
    int cnt = 0;
    
    for(int i=2; i<=n; i++) {
        if(max < dist[i]) {
            max = dist[i];
            node = i;
            cnt = 1;
        } else if(max == dist[i]) {
            cnt++;
        }
    }
    
    
    int answer = cnt;
    return answer;
}