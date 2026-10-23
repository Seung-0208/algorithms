#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int cnt = 0;
unordered_set<int> numberCases;
vector<bool> isUsed;

bool isPrime(int number) {
    vector<bool> prime(number+1, true);
    prime[0] = false;
    prime[1] = false;
    
    for(int i=2; i*i<=number; i++) {
        if(!prime[i]) continue;
        
        for(int j=i*i; j<=number; j+=i) {
            prime[j] = false;
        }
    }
    return prime[number];
}

void DFS(string currString, int length, string numbers) {
    if(currString.size() == length) {
        numberCases.insert(stoi(currString));
        cout << currString << "\n";
        return;
    }
    
    for(int i=0; i<cnt; i++) {
        if(!isUsed[i]) {
            isUsed[i] = true;
            DFS(currString + numbers[i], length, numbers);
            isUsed[i] = false;
        }
    }
}

int solution(string numbers) {
    cnt = numbers.size();
    isUsed.assign(numbers.size(), false);
    
    for(int i=1; i<=cnt; i++) {
        DFS("", i, numbers);
    }
    int answer = 0;
    for(int num : numberCases) {
        if(isPrime(num)) {
            cout << "prime num: " << num << "\n";
            answer++;
        }
    }
    return answer;
}