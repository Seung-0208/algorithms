#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int solution(int distance, vector<int> rocks, int n) {
    sort(rocks.begin(), rocks.end());
    vector<int> allRocks(rocks.size()+2);
    allRocks[0] = 0;
    int i = 1;
    for(int r : rocks) {
        allRocks[i] = r;
        i++;
    }
    allRocks[i] = distance;
    
    int s = 0, e = distance*2;
    
    int answer = 0;
    
    while(s<=e) {
        int X = (s+e)/2;
        
        int prev = 0;
        int removed = 0;
        
        for(int i=1; i<allRocks.size(); i++) {
            int r = allRocks[i];
            if(r-prev < X) {
                removed++;
                if(removed > n) break;
            } else {
                prev = r;
            }
        }
        
        if(removed > n) { //최소거리 X보다 더 작은 간격이 있음
            e = X-1;
        } else {
            answer = X;
            s = X+1;
        }
    }
        
        
    
    return answer;
}