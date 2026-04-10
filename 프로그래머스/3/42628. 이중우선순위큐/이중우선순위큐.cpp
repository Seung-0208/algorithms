#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

vector<int> solution(vector<string> operations) {
    
    priority_queue<int> bigger;
    priority_queue<int, vector<int>, greater<int>> smaller;
    
    for(string order : operations) {
        stringstream ss(order);
        string tok;
        int i = 0;
        string type;
        int param;
        while(ss >> tok) {
            if(i==0) type  = tok;
            if(i==1) param = stoi(tok);
            i++;
        }
        
        if(type == "I") {
            bigger.push(param);
            smaller.push(param);
        } else {
            if(param == 1) {
                if(!bigger.empty()) {
                    int max = bigger.top();
                    bigger.pop();
                    vector<int> temp;
                    while(true) {
                        int t = smaller.top();
                        smaller.pop();
                        if(t == max) {
                            break;
                        } else {
                            temp.push_back(t);
                        }
                    }
                    for(int t : temp) smaller.push(t); //원상복구
                }
            } else {
                if(!smaller.empty()) {
                    int min = smaller.top();
                    smaller.pop();
                    vector<int> temp;
                    while(true) {
                        int t = bigger.top();
                        bigger.pop();
                        if(t == min) break;
                        else temp.push_back(t);
                    }
                    for(int t : temp) bigger.push(t); //원상복구
                }
            }
        }
    }
    
    vector<int> answer(2,0);
    
    if(bigger.empty()) {
        answer[0] = 0; answer[1] = 0;
    } else {
        answer[0] = bigger.top(); answer[1] = smaller.top();
    }
    return answer;
}