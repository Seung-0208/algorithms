#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

bool isPossible(long long T, vector<int>& times, int n) {
    long long sum = 0;
    for(int t : times) {
        sum += (T/t);
        if(sum >= n) return true;
    }
    return false;
}

long long solution(int n, vector<int> times) {
    
    sort(times.begin(), times.end());
    
    long long s = 0;
    long long e = 1LL* times[0]*n;
    
    long long answer = 0;
    
    
    while(s<=e) {
        long long T = (s+e)/2;
        bool result = isPossible(T, times, n);
        if(result) {
            answer = T;
            e = T-1;
        } else {
            s = T+1;
        }
    }
    
    return answer;
}