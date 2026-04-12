#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

long long solution(int n, vector<int> times) {
    
    long long s = 0, e = 10000000000000;
        
    long long answer = 0;
    
    while(s<=e) {
        long long k = (s+e)/2;
        cout << k << "\n";
        
        long long cnt = 0;
        
        for(int t : times) {
            cnt += k/t;
            if(cnt >= n) break;
        }
        
        if(cnt >= n) {
            answer = k;
            e = k-1;
        } else {
            s = k+1;
        }
    }
    
    return answer;
}