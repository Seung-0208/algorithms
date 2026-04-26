#include <string>
#include <vector>
#include <bits/stdc++.h>
#include <climits>

using namespace std;

long long solution(int n, vector<int> times) {
    sort(times.begin(), times.end());
    long long s = 0;
    // long long e = times[times.size()-1]*n*2;
    long long e = 9000000000000;
    
    long long answer = INT_MAX;
    
    while(s<=e) {
        long long mid = (s+e)/2;
        long long temp = 0;
        for(int t : times) {
            temp += (mid/t);
        }
        
        if(temp >= n) {
            answer = mid;
            e = mid-1;
        } else {
            s = mid+1;
        }
    }
    
    return answer;
}