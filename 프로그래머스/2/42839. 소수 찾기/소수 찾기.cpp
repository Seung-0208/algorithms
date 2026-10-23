#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

unordered_set<int> numberCases;
vector<bool> isUsed;
int cnt;

bool isPrime(int num) {
    vector<bool> prime(num+1, true);
    prime[0] = false;
    prime[1] = false;
    
    for(int i=2; i*i <= num; i++) {
        if(!prime[i]) continue;
        
        for(int j=i*i; j<=num; j+=i) {
            prime[j] = false;
        }
    }
    return prime[num];
}

void DFS(string curString, int length, string numbers) {
    if(curString.size() == length) {
        numberCases.insert(stoi(curString));
        return;
    }
    
    for(int i=0; i<cnt; i++) {
        if(!isUsed[i]) {
            isUsed[i] = true;
            DFS(curString + numbers[i], length, numbers);
            isUsed[i] = false;
        }
    }
}

int solution(string numbers) {
    cnt = numbers.size();
    isUsed.assign(cnt, false);
    
    for(int i=1; i<=cnt; i++) {
        DFS("", i, numbers);
    }
    int answer = 0;
    for(int n : numberCases) {
        if(isPrime(n)) answer++;
    }
    return answer;
}