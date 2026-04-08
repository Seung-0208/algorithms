#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int main() {

    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int N, M;
    cin >> N >> M;

    unordered_map<int, string> findName;
    unordered_map<string, int> findNumber;

    for(int i=1; i<=N; i++) {
        string line;
        cin >> line;
        findName.insert({i, line});
        findNumber.insert({line, i});
    }

    for(int i=1; i<=M; i++) {
        string line;
        cin >> line;
        bool isNumber = isdigit(line[0]);
        if(isNumber) {
            cout << findName[stoi(line)] << "\n";
        } else {
            cout << findNumber[line] << "\n";
        }
    }

    return 0;
}