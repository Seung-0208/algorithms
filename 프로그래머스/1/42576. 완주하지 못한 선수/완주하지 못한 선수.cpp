#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    
    unordered_map<string, int> count;
    
    for(string name : participant) {
        count[name]++;
    }
    
    for(string name : completion) {
        count[name]--;
    }
    
    string answer = "";
    
    for(auto& p : count) {
        if(p.second > 0) {
            answer = p.first;
            break;
        }
    }
    return answer;
}