#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> citations) {
    int n = citations.size();
    sort(citations.begin(), citations.end());
    
    int answer = 0;
    for(int i=0; i<n; i++) {
        int temp = min(citations[i], n-i);
        if(temp > answer) answer = temp;
    }
    
    return answer;
}