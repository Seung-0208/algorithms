#include <string>
#include <vector>

using namespace std;

vector<vector<int>> graph;
vector<bool> isVisited;

void DFS(int n) {
    for(int c : graph[n]) {
        if(!isVisited[c]) {
            isVisited[c] = true;
            DFS(c);
        }
    }
}

int solution(int n, vector<vector<int>> computers) {
    graph.assign(n, vector<int>());
    isVisited.assign(n, false);
    for(int i=0; i<n-1; i++) {
        for(int j=i+1; j<n; j++) {
            if(computers[i][j] == 1) {
                graph[i].push_back(j);
                graph[j].push_back(i);
            } 
        }
    }
    
    int answer = 0;
    for(int i=0; i<n; i++) {
        if(!isVisited[i]) {
            isVisited[i] = true;
            DFS(i);
            answer++;
        }
    }
    return answer;
}