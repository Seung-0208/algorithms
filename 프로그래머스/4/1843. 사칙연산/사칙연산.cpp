#include <vector>
#include <string>
#include <bits/stdc++.h>
using namespace std;

int solution(vector<string> arr)
{
    vector<int> nums;
    vector<string> ops;
    for(int i=0; i<arr.size(); i++) {
        if(i%2 == 0) nums.push_back(stoi(arr[i]));
        else ops.push_back(arr[i]);
    }
    
    int m = nums.size();
    int INF = 1e9;
    vector<vector<int>> maxDP(m, vector<int>(m, -INF));
    vector<vector<int>> minDP(m, vector<int>(m, INF));
    
    for(int i=0; i<m; i++) {
        maxDP[i][i] = nums[i];
        minDP[i][i] = nums[i];
    }
    
    for(int len = 2; len <= m; len++) {
        for(int i=0; i+len-1<m; i++) {
            int j = i+len-1;
            for(int k=i; k<j; k++) {
                if(ops[k]=="+") {
                    if(maxDP[i][j] < maxDP[i][k] + maxDP[k+1][j]) maxDP[i][j] = maxDP[i][k] + maxDP[k+1][j];
                    if(minDP[i][j] > minDP[i][k] + minDP[k+1][j]) minDP[i][j] = minDP[i][k] + minDP[k+1][j];
                } else {
                    if(maxDP[i][j] < maxDP[i][k] - minDP[k+1][j]) maxDP[i][j] = maxDP[i][k] - minDP[k+1][j];
                    if(minDP[i][j] > minDP[i][k] - maxDP[k+1][j]) minDP[i][j] = minDP[i][k] - maxDP[k+1][j];
                }
            }
        }
    }
    
    int answer = maxDP[0][m-1];
    return answer;
}