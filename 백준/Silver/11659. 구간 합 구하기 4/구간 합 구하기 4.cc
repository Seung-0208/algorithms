#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int main() {

    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, M;
    cin >> N >> M;

    vector<int> sum(N+1, 0);

    for(int i=1; i<N+1; i++) {
        cin >> sum[i];
    }

    for(int i=1; i<=N; i++) {
        sum[i] += sum[i-1];
    }

    for(int i=0; i<M; i++) {
        int a, b;
        cin >> a >> b;
        cout << sum[b]-sum[a-1] << "\n";
    }
    

    return 0;
}