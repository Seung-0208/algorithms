#include<vector>
#include<bits/stdc++.h>
using namespace std;

int solution(vector<vector<int> > maps)
{
    int n = maps.size();
    int m = maps[0].size();
    
    vector<vector<int>> guide = {{1,-1,0,0}, {0,0,1,-1}};
    vector<vector<bool>> isVisited(n, vector<bool>(m, false));
    vector<vector<int>> dist(n, vector<int>(m, 0));
    queue<pair<int,int>> q;
    q.push({0,0});
    isVisited[0][0] = true;
    dist[0][0] = 1;
    
    while(!q.empty()) {
        
        int r = q.front().first;
        int c = q.front().second;
        q.pop();
        
        for(int i=0; i<4; i++) {
            int nr = r + guide[0][i];
            int nc = c + guide[1][i];
            
            if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
            if(maps[nr][nc] == 0) continue;
            if(isVisited[nr][nc]) continue;
            
            isVisited[nr][nc] = true;
            dist[nr][nc] = dist[r][c] + 1;
            if(nr == n-1 && nc == m-1) break;
            q.push({nr, nc});
        }
    }
    
    if(dist[n-1][m-1] == 0) return -1;
    return dist[n-1][m-1];
}