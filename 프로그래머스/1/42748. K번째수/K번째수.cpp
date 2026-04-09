#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int getNum(int i, int j, int k, vector<int> array) {
    priority_queue<int> smallNums;
    priority_queue<int, vector<int>, greater<int>> largeNums;
    
    for(int idx=i-1; idx<j; idx++) {
        if(smallNums.size() < k) smallNums.push(array[idx]);
        else if(smallNums.size() == k) {
            if(smallNums.top() > array[idx]) {
                int temp = smallNums.top();
                smallNums.pop();
                smallNums.push(array[idx]);
                largeNums.push(temp);
            } else {
                largeNums.push(array[idx]);
            }
        }
    }
    return smallNums.top();
}

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    
    vector<int> answer;
    
    for(vector<int> c : commands) {
        int ans = getNum(c[0], c[1], c[2], array);
        answer.push_back(ans);
    }
    return answer;
}