#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int main() {

    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;

    vector<int> nums(N, 0);

    for(int i=0; i<N; i++) cin >> nums[i];

    vector<int> tails;
    tails.reserve(N);

    vector<int> pos(N);

    for(int i=0; i<N; i++) {
        auto it = lower_bound(tails.begin(), tails.end(), nums[i]);
        int idx = (int)(it - tails.begin());
        if(it == tails.end()) {
            tails.push_back(nums[i]);
        } else {
            *it = nums[i];
        }

        pos[i] = idx;
    }

    cout << tails.size() << "\n";

    vector<int> ans(tails.size());
    int need = tails.size()-1;

    for(int i=N-1; i>=0; i--) {
        if(pos[i] == need) {
            ans[need]= nums[i];
            need--;
            if(need<0) break;
        }
    }

    for(int n : ans) {
        cout << n << " ";
    }


    return 0;
}