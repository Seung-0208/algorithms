#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int calculatePlus(string param) {
    stringstream ss(param);
    string tok;

    int ans = 0;

    while(getline(ss, tok, '+')) {
        ans += (stoi(tok));
    }

    return ans;
}

int main() {

    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string line;
    cin >> line;

    stringstream ss(line);
    string tok;

    vector<int> nums;

    while(getline(ss, tok, '-')) {
        nums.push_back(calculatePlus(tok));
    }

    int ans = nums[0];

    for(int i=1; i<nums.size(); i++) {
        ans -= nums[i];
    }

    cout << ans << endl;

    return 0;
}