#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

struct CMP {
    bool operator() (int a, int b) const {
        string a1 = to_string(a);
        string b1 = to_string(b);
        
        int temp1 = stoi(a1+b1);
        int temp2 = stoi(b1+a1);
        
        return temp1 <= temp2;
    }  
};

string solution(vector<int> numbers) {
    string answer = "";
    priority_queue<int, vector<int>, CMP> q;
    bool isAllZero = true;
    for(int n : numbers){
        if(n != 0) isAllZero = false;
        q.push(n);
    }
    
    if(isAllZero) return "0";
    
    while(!q.empty()) {
        int t = q.top();
        q.pop();
        answer += to_string(t);
    }
    
    
    return answer;
}