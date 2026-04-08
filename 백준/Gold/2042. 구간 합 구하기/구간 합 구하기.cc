#include <iostream>
#include <bits/stdc++.h>
#include <climits>

using namespace std;

vector<long long> tree;

//트리 기준 인덱스 값
long long getSum(int i, int j) {
    long long sum = 0;
    while(i<=j) {
        if(i%2 != 0) {
            sum += tree[i];
            i++;
        }
        if(j%2 == 0) {
            sum += tree[j];
            j--;
        }
        i /= 2;
        j /= 2;
    }
    return sum;
}

//트리 기준 인덱스 값
void change(int idx, long long value) {
    tree[idx] = value;
    
    while(idx/2 > 0) {
        idx /= 2;
        tree[idx] = tree[idx*2] + tree[idx*2+1];
    }
}


int main() {

    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, M, K;
    cin >> N >> M >> K;

    int t = 1;
    int temp = 2;
    while(temp <= N) temp *= 2;

    tree.assign(temp*2, 0);

    for(int i=0; i<N; i++) {
        cin >> tree[temp+i];
    }

    //트리 초기화
    for(int i=temp-1; i>0; i--) {
        tree[i] = tree[i*2]+tree[i*2+1];
    }

    for(int i=0; i<M+K; i++) {
        int a, b;
        long long c;
        cin >> a >> b >> c;

        if(a == 1) change(b+temp-1, c);
        if(a == 2) cout << getSum(b+temp-1, ((int)c)+temp-1) << "\n";
    }


    return 0;
}