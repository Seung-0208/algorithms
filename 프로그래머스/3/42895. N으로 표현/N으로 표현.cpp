#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int makeRepeatNumber(int N, int cnt) {
    string temp = "";
    for(int i=0; i<cnt; i++) {
        temp += to_string(N);
    }
    return stoi(temp);
}

int solution(int N, int number) {
    
    vector<vector<long long>> cases(9, vector<long long>());
    
    for(int i=1; i<9; i++) {
        int t = makeRepeatNumber(N, i);
        if(t == number) return i;
        cases[i].push_back(t);
    }
    
    for(int i=2; i<9; i++) {
        for(int j=1; j<=i-1; j++) {
            for(long long a : cases[j]) {
                for(long long b : cases[i-j]) {
                    if(a+b == number) return i;
                    cases[i].push_back(a+b);
                    if(a-b == number) return i;
                    cases[i].push_back(a-b);
                    if(b-a == number) return i;
                    cases[i].push_back(b-a);
                    if(a*b == number) return i;
                    cases[i].push_back(a*b);
                    if(b != 0) {
                        if(a/b == number) return i;
                        cases[i].push_back(a/b);
                    }
                    if(a != 0) {
                        if(b/a == number) return i;
                        cases[i].push_back(b/a);
                    }
                }
            }
        }    
    }
    
    return -1;
}