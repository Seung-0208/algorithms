#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> citations) {
    sort(citations.begin(), citations.end());
    int n = citations.size();
    
    int answer = 0;
    for(int i=0; i<n; i++) {
        int temp = n-i;
        if(temp > citations[i]) temp = citations[i];
        if(answer < temp) answer = temp;
    }
    
    
    return answer;
}