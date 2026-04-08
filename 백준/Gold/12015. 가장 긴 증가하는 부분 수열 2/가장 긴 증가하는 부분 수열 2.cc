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

    for(int n : nums) {
        auto it = lower_bound(tails.begin(), tails.end(), n);
        if(it == tails.end()) tails.push_back(n);
        else *it = n;
    }

    cout << tails.size() << endl;
    

    return 0;
}