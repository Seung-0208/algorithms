#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int main() {

    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;

    vector<int> nums(N, 0);
    vector<int> ans(N, 0);

    for(int i=0; i<N; i++) cin >> nums[i];

    ans[N-1] = -1;

    stack<int> s;

    for(int i=N-1; i>=0; i--) {
        while(!s.empty() && s.top() <= nums[i]) {
            s.pop();
        }
        if(s.empty()) ans[i] = -1;
        else {
            ans[i] = s.top();
        }
        s.push(nums[i]);
    }

    for(int i : ans) {
        cout << i << " ";
    }

    return 0;
}