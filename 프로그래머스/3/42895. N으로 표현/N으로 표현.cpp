#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int makeRepeatNumber(int n, int N) {
    string temp = "";
    for(int i=0; i<n; i++) temp += to_string(N);
    return stoi(temp);
}

int solution(int N, int number) {
    
    vector<unordered_set<int>> cases(9);
    
    for(int i=1; i<9; i++) {
        int temp = makeRepeatNumber(i, N);
        cases[i].insert(temp);
        if(temp == number) {
            return i;
        }
    }
    
    for(int i=2; i<9; i++) {
        int s = 1;
        int e = i-1;
        while(s <= e && s+e == i) {
            for(int a : cases[e]) {
                for(int b : cases[s]) {
                    if(a+b == number) return i;
                    cases[i].insert(a+b);
                    if(a-b == number) return i;
                    cases[i].insert(a-b);
                    if(b-a == number) return i;
                    cases[i].insert(b-a);
                    if(a*b == number) return i;
                    cases[i].insert(a*b);
                    if(b != 0) {
                        if(a/b == number) return i;
                        cases[i].insert(a/b);
                    }
                    if(a != 0) {
                        if(b/a == number) return i;
                        cases[i].insert(b/a);
                    }
                }
            }
            s++; e--;
        }
    }
    
    return -1;
}