#include <vector>
#include <string>
#include <cmath>
using namespace std;

int solution(vector<string> arr)
{
    vector<int> nums;
    vector<char> opers;
    
    for(string s : arr) {
        if(isdigit(s[0])) nums.push_back(stoi(s));
        else opers.push_back(s[0]);
    }
    
    int INF = 1e9;
    
    int N = nums.size();
    vector<vector<int>> maxDP(N, vector<int>(N, INF*(-1)));
    vector<vector<int>> minDP(N, vector<int>(N, INF));
    
    for(int i=0; i<N; i++) {
        maxDP[i][i] = nums[i];
        minDP[i][i] = nums[i];
    }
    
    for(int L=2; L<=N; L++) {
        for(int i=0; i+L-1<N; i++) {
            int j = i+L-1;
            for(int k=i; k<j; k++) {
                if(opers[k] =='-') {
                    maxDP[i][j] = max(maxDP[i][j], maxDP[i][k]-minDP[k+1][j]);
                    minDP[i][j] = min(minDP[i][j], minDP[i][k] - maxDP[k+1][j]);
                } else {
                    maxDP[i][j] = max(maxDP[i][j], maxDP[i][k] + maxDP[k+1][j]);
                    minDP[i][j] = min(minDP[i][j], minDP[i][k] + minDP[k+1][j]);
                }
            }
        }
    }
    
    return maxDP[0][N-1];
}