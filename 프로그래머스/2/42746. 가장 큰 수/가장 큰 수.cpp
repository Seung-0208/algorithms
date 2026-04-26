#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

struct CMP {
    bool operator() (int a, int b) const {
        int v1 = stoi(to_string(a) + to_string(b));
        int v2 = stoi(to_string(b) + to_string(a));
        
        return v1 < v2;
    }
};

string solution(vector<int> numbers) {
    priority_queue<int, vector<int>, CMP> pq;
    bool isAllZero = true;
    for(int n : numbers) {
        pq.push(n);
        if(n!=0) isAllZero = false;
    }
    
    if(isAllZero) return "0";
    
    string answer = "";
    while(!pq.empty()) {
        answer += to_string(pq.top());
        pq.pop();
    }
    return answer;
}