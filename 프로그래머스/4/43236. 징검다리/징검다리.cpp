#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int solution(int distance, vector<int> rocks, int n) {
    vector<int> arr(rocks.size()+2, 0);
    
    sort(rocks.begin(), rocks.end());
    
    arr[rocks.size()+1] = distance;
    for(int i=1; i<=rocks.size(); i++) {
        arr[i] = rocks[i-1];
    }
    
    int s = 0, e = distance*2;
    int answer = 0;
    
    while(s<=e) {
        int prev = 0; //마지막으로 남긴 돌
        int removed = 0; //없앤 돌의 개수
        
        int k = (s+e)/2;
        
        bool isPossible = true;
        
        for(int i=1; i<rocks.size()+2; i++) {
            if(arr[i]-prev < k) removed++;
            else prev = arr[i];
            
            if(removed > n) {
                isPossible = false;
                break;
            }
        }
        
        if(isPossible) {
            s = k+1;
            answer = k;
        } else {
            e = k-1;
        }
    }
    
    return answer;
}