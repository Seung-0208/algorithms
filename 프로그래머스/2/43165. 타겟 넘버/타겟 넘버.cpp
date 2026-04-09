#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

vector<vector<char>> cases;
vector<vector<bool>> isVisited;
int N;
int answer = 0;

void DFS(int idx, vector<char>& t) {
    if(idx == N) {
        cases.push_back(t);
        return;
    }
    
    t[idx] = '+';
    DFS(idx+1, t);
    
    t[idx] = '-';
    DFS(idx+1, t);
}

int solution(vector<int> numbers, int target) {
    N = numbers.size();
    isVisited.assign(numbers.size(), vector<bool>(2, false));
    vector<char> temp(N);
    DFS(0, temp);
    
    int answer = 0;
    for(vector<char> c : cases) {
        int t = 0;
        for(int i=0; i<N; i++) {
            if(c[i] == '-') t -= numbers[i];
            else t += numbers[i];
        }   
        if(t == target) answer++;
    }
    
    return answer;
}