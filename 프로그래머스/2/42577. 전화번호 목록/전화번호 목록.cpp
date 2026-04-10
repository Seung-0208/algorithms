#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

bool solution(vector<string> phone_book) {
    unordered_set<string> tokens;
    for(string phone : phone_book) {
        tokens.insert(phone);
    }
    
    for(string phone : phone_book) {
        for(int i=0; i<phone.size()-1; i++) {
            string temp = phone.substr(0, i+1);
            if(tokens.count(temp)) {
                
                return false;
            }
        }
    }

    return true;
}