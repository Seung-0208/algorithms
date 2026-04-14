#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;



int solution(vector<vector<string>> clothes) {
    
    unordered_map<string, int> clothesInfo;    
    for(vector<string> cloth : clothes) {
        clothesInfo[cloth[1]]++;
    }
    int answer = 1;
    for(auto& p : clothesInfo) {
        p.second++;
        answer *= p.second;
    }
    
    answer -= 1;
    
    return answer;
}