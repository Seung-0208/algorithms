#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> citations) {
    int N = citations.size();
    
    sort(citations.begin(), citations.end());
    int answer = 0;
    for(int i=0; i<citations.size(); i++) {
        int temp = citations[i];
        if(temp > N-i) temp = N-i;
        if(answer < temp) answer = temp;
    }
    
    return answer;
}