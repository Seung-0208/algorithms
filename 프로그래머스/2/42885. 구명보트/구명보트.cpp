#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> people, int limit) {
    sort(people.begin(), people.end());
    
    int answer = 0;
    int s = 0, e = people.size()-1;
    while(s <= e) {
        int temp = people[s] + people[e];
        answer++;
        if(temp <= limit) {
            s++;
            e--;
        } else {
            e--;
        }
    }
    return answer;
}