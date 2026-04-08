#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int main() {

    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;

    vector<long long> nums(N, 0);

    for(int i=0; i<N; i++) cin >> nums[i];

    if(N==2) {
        cout << 0 << endl;
        return 0;
    }

    sort(nums.begin(), nums.end());

    int cnt = 0;

    for(int i=0; i<N; i++) {
        int s = 0, e = N-1;
        while(s<e) {
            long long temp = nums[s]+nums[e];
            if(s == i) {
                s++;
                continue;
            }
            if(e == i) {
                e--;
                continue;
            }
            if(nums[i] < temp) {
                e--;
            }
            else if(nums[i] > temp) {
                s++;
            }
            else {
                cnt++;
                break;
            }
        }
    }

    cout << cnt << endl;

    return 0;
}