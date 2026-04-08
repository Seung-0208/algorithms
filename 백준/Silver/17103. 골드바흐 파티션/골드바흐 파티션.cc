#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int main() {

    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int MAX = 1000000;
    vector<bool> isPrime(MAX+1, true);

    isPrime[0] = false;
    isPrime[1] = false;

    for(long long i=2; i*i<=MAX; i++) {
        if(!isPrime[i]) continue;

        for(long long j=i*i; j<=MAX; j+=i) {
            isPrime[(int)j] = false;
        }
    }

    //소수 모음
    vector<long long> primes;
    for(int i=2; i<=MAX; i++) {
        if(isPrime[i]) primes.push_back(i);
    }
    
    int T;
    cin >> T;

    for(int i=0; i<T; i++) {
        int N;
        cin >> N;

        int s=0, e=primes.size()-1;
        int cnt = 0;
        while(s<=e) {
            int temp = primes[s]+primes[e];
            if(N > temp) s++;
            else if(N < temp) e--;
            else {
                s++; e--;
                cnt++;
            }
        }
        cout << cnt << "\n";
    }

    return 0;
}