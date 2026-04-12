#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

struct CMP {
    bool operator()(int a, int b) const {
        string as = to_string(a);
        string bs = to_string(b);
        
        return (as+bs) < (bs+as);
    }
};

string solution(vector<int> numbers) {
    
    priority_queue<int, vector<int>, CMP> pq;
    
    bool isAllZero = true;
    for(int n : numbers) {
        if(n!=0 && isAllZero) isAllZero = false;
        pq.push(n);
    }
    
    if(isAllZero) return "0";
    
    string answer = "";
    
    while(!pq.empty()) {
        answer += to_string(pq.top());
        pq.pop();
    }
        
    return answer;
}