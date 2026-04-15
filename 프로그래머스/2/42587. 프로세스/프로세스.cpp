#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

struct Node{
    int idx;
    int priority;
};

int solution(vector<int> priorities, int location) {
    int n = priorities.size();
    vector<int> locationInfo(n, 0);
    vector<int> priorityCnt(10, 0);
    
    queue<Node> q;
    int order = 1; //순서
    int max = 0; //가장 큰 값
    
    for(int i=0; i<n; i++) {
        q.push({i, priorities[i]});
        priorityCnt[priorities[i]]++;
        if(max < priorities[i]) max = priorities[i];
    }
    
    while(!q.empty()) {
        if(q.front().priority < max) {
            q.push(q.front());
            q.pop();
        } else {
            // while(q.front().priority == max) {
                locationInfo[q.front().idx] = order;
                order++;
                q.pop();
                priorityCnt[max]--;
            // }
            if(priorityCnt[max] == 0) {
                while(priorityCnt[max] == 0) max--;
            }
        }
    }
    
    int answer = locationInfo[location];
    return answer;
}