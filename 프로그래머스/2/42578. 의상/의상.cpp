#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int solution(vector<vector<string>> clothes) {
    
    unordered_map<string, int> matching;
    for(vector<string> item : clothes) {
        matching[item[1]]++;
    }
    
    int answer = 1;
    for(auto& p : matching) {
        answer *= p.second+1;
    }
    
    return answer-1;
}