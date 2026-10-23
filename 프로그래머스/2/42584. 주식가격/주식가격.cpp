#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> prices) {
    int n = prices.size();
    stack<int> st;
    vector<int> answer(n,0);
    
    for(int i=0; i<n; i++) {
        while(!st.empty() && prices[st.top()] > prices[i]) {
            int prev = st.top();
            st.pop();
            answer[prev] = i-prev;
        }
        st.push(i);
    }
    
    while(!st.empty()) {
        int prev = st.top();
        st.pop();
        answer[prev] = n-prev-1;
    }
    
    return answer;
}