#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int main() {

    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;

    vector<int> nums(N, 0);
    vector<int> pos(N, 0);
    for(int i=0; i<N; i++) cin >> nums[i];

    vector<int> temp;
    temp.reserve(N);

    for(int i=0; i<N; i++) {
        auto it = lower_bound(temp.begin(), temp.end(), nums[i]);
        int idx = it-temp.begin();

        if(it == temp.end()) temp.push_back(nums[i]);
        else *it = nums[i];

        pos[i] = idx;
    }

    cout << temp.size() << "\n";

    vector<int> ansArr(temp.size(), 0);
    int L = temp.size()-1;

    for(int i=N-1; i>=0; i--) {
        if(pos[i] == L) {
            ansArr[L] = nums[i];
            L--;
        }
    }

    for(int n : ansArr) {
        cout << n << " ";
    }

    cout << endl;

    return 0;
}