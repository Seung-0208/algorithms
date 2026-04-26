#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int solution(int distance, vector<int> rocks, int n) {
    sort(rocks.begin(), rocks.end());
    vector<int> board(rocks.size()+2, 0);
    for(int i=0; i<rocks.size(); i++) {
        board[i+1] = rocks[i];
    }
    board[rocks.size()+1] = distance;
    
    int s = 0;
    int e = distance*2;
    int answer = 0;
    while(s<=e) {
        int minDist = (s+e)/2;
        int removed = 0;
        int prev = 0;
        
        for(int i=1; i<rocks.size()+2; i++) {
            if(board[i]-prev < minDist) removed++;
            else {
                prev = board[i];
            }
            if(removed > n) break;
        }
        
        if(removed > n) e = minDist - 1;
        else {
            answer = minDist;
            s = minDist + 1;
        }
    }
    
    return answer;
}