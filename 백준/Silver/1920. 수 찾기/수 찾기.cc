#include <iostream>
#include <bits/stdc++.h>

using namespace std;

vector<int> nums;

int main() {

    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;
    nums.assign(N, 0);
    for(int i=0; i<N; i++) cin >> nums[i];

    sort(nums.begin(), nums.end());

    int M;
    cin >> M;
    vector<int> params(M);
    for(int i=0; i<M; i++) cin >> params[i];

    for(int param : params) {
        int i = 0, j = N-1;
        bool isExist = false;
        while(i <= j) {
            int m = (i+j)/2;
            if(param < nums[m]) {
                j = m-1;
            } else if(param > nums[m]) {
                i = m+1;
            } else {
                isExist = true;
                break;
            }
        }
        if(isExist) cout << 1 << "\n";
        else cout << 0 << "\n";
    }


    return 0;
}