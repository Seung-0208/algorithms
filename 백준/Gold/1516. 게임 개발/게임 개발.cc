#include <iostream>
#include <bits/stdc++.h>

using namespace std;

vector<int> timeInfo;
vector<int> neededTime;
vector<int> inputs;
vector<vector<int>> nextBuilding;

void calculate() {
    queue<int> q;
    for(int i=1; i<inputs.size(); i++) {
        if(inputs[i] == 0) q.push(i);
    }

    while(!q.empty()) {
        int cur = q.front();
        q.pop();

        for(int next : nextBuilding[cur]) {
            if(inputs[next] > 0) {
                inputs[next]--;
                if(neededTime[next] < neededTime[cur] + timeInfo[cur]) {
                    neededTime[next] = neededTime[cur] + timeInfo[cur];
                }
                if(inputs[next] == 0) {
                    q.push(next);
                }
            }
        }
    }
}

int main() {

    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;
    timeInfo.assign(N+1, 0);
    nextBuilding.assign(N+1, vector<int>());
    neededTime.assign(N+1, 0);
    inputs.assign(N+1, 0);

    for(int i=1; i<=N; i++) {
        //시간
        cin >> timeInfo[i];

        //먼저 지어져야 할 건물
        while(1) {
            int temp;
            cin >> temp;
            if(temp == -1) break;
            nextBuilding[temp].push_back(i);
            inputs[i]++;
        }
    }

    calculate();

    for(int i=1; i<=N; i++) {
        cout << (neededTime[i] + timeInfo[i]) << "\n";
    }

    return 0;
}