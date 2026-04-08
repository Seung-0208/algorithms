#include <iostream>
#include <bits/stdc++.h>

using namespace std;

struct Num {
    int value, idx;
};

int main() {

    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, L;
    cin >> N >> L;

    deque<Num> q;

    for(int i=0; i<N; i++) {
        int temp;
        cin >> temp;

        while(!q.empty() && q.back().value >= temp) {
            q.pop_back();
        }

        while(!q.empty() && (i-q.front().idx+1) > L) {
            q.pop_front();
        }

        q.push_back({temp, i});
        cout << q.front().value << " ";
    }

    return 0;
}