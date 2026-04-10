#include<string>
#include <iostream>
#include <bits/stdc++.h>

using namespace std;

bool solution(string s)
{
    vector<char> stack;
    
    for(int i=0; i<s.size(); i++) {
        if(stack.empty() && s[i] == ')') return false;
        else if(s[i] == '(') stack.push_back('(');
        else if(s[i] == ')') stack.pop_back();
    }
    
    if(stack.empty()) return true;
    else return false;
}