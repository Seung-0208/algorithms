#include <iostream>
#include <bits/stdc++.h>

using namespace std;

struct Node {
    int value;
    int idx;
};

bool cmp(const Node&a, const Node&b) {
    if(a.value != b.value) return a.value < b.value;
    return a.idx < b.idx;
}

int main() {

    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;

    vector<Node> nums(N);

    for(int i=0; i<N; i++) {
        int temp;
        cin >> temp;
        nums[i] = {temp, i};
    }

    sort(nums.begin(), nums.end(), cmp);

    int ans = 0;
    
    for(int i=0; i<N; i++) {
        int temp = nums[i].idx - i;
        if(ans < temp) ans = temp;
    }

    cout << ans+1 << endl;
    

    return 0;
}