#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int N, K;
vector<int> nums;

void swap(int a, int b) {
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
}

int getPivot(int s, int e) {
    int m = (s+e)/2;
    swap(s, m);
    int pivot = nums[s];
    int i = s+1, j = e;
    
    while(i<=j) {
        while(i<=e && nums[i] < pivot) i++;
        while(j>=s && nums[j] > pivot) j--;
        if(i<=j) swap(i++, j--);
    }

    nums[s] = nums[j];
    nums[j] = pivot;
    return j;
}

void quickSort(int s, int e) {
    if(s >= e) return;
    int pivot = getPivot(s, e);
    if(K < pivot) quickSort(s, pivot-1);
    else if(K > pivot) quickSort(pivot+1, e);
}

int main() {

    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N >> K;
    nums.assign(N, 0);
    K-=1;

    for(int i=0; i<N; i++) cin >> nums[i];

    quickSort(0, N-1);
    cout << nums[K] << endl;


    return 0;
}