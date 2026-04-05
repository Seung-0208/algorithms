#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int N;
vector<int> nums;
vector<int> copyNums;

void mergeSort(int s, int e) {
    if(s >= e) return;

    int m = (s+e)/2;
    mergeSort(s, m);
    mergeSort(m+1, e);

    for(int i=s; i<=e; i++) copyNums[i] = nums[i];

    int i = s, j = m+1;
    int k = s;
    while(i <= m && j <= e) {
        if(copyNums[i] < copyNums[j]) {
            nums[k] = copyNums[i];
            i++;
        } else {
            nums[k] = copyNums[j];
            j++;
        }
        k++;
    }

    while(i<=m) {
        nums[k] = copyNums[i];
        k++; i++;
    }

    while(j<=e) {
        nums[k] = copyNums[j];
        k++; j++;
    }
}

int main() {

    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N;

    nums.assign(N, 0);
    copyNums.assign(N, 0);
    for(int i=0; i<N; i++) cin >> nums[i];

    mergeSort(0, N-1);

    for(int n : nums) {
        cout << n << "\n";
    }


    return 0;
}