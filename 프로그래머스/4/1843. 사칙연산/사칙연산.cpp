#include <vector>
#include <string>
#include <cmath>
using namespace std;

int solution(vector<string> arr)
{
    vector<int> nums;
    vector<string> opers;
    
    for(string s : arr) {
        if(s == "-" || s == "+") opers.push_back(s);
        else nums.push_back(stoi(s));
    }
    
    int N = nums.size();
    
    int INF = 1e9;
    vector<vector<int>> maxDP(N, vector<int>(N, (-1)*INF));
    vector<vector<int>> minDP(N, vector<int>(N, INF));
    
    for(int i=0; i<N; i++) {
        maxDP[i][i] = nums[i];
        minDP[i][i] = nums[i];
    }
    
    for(int len = 2; len<=N; len++) {
        for(int i=0; i+len-1<N; i++) {
            int j = i+len-1;
            for(int k=i; k<j; k++) {
                if(opers[k] == "+") {
                    maxDP[i][j] = max(maxDP[i][j], maxDP[i][k]+maxDP[k+1][j]);
                    minDP[i][j] = min(minDP[i][j], minDP[i][k]+minDP[k+1][j]);
                } else {
                    maxDP[i][j] = max(maxDP[i][j], maxDP[i][k]-minDP[k+1][j]);
                    minDP[i][j] = min(minDP[i][j], minDP[i][k]-maxDP[k+1][j]);
                }
            }
        }
    }
    
    return maxDP[0][N-1];
}