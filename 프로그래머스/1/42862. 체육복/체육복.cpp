#include <string>
#include <vector>

using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    vector<int> count(n, 1);
    for(int i : lost) {
        count[i-1]--;
    }
    for(int i : reserve) {
        count[i-1]++;
    }
    
    for(int i=0; i<n; i++) {
        if(count[i] == 2) {
            if(i>0 && count[i-1] == 0) {
                count[i-1]=1;
                count[i]--;
            } else if(i+1 < n && count[i+1] == 0) {
                count[i+1] = 1;
                count[i]--;
            }
        }
    }
    
    int answer = 0;
    for(int i : count) {
        if(i > 0) answer++;
    }
    return answer;
}