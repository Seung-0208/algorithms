#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

struct node {
    string word;
    int idx;
};

bool isTargetInWords(string target, vector<string>& words) {
    for(string t : words) {
        if(t==target) return true;
    }
    return false;
}

bool isPossible(string a, string b) {
    int cnt = 0;
    for(int i=0; i<a.size(); i++) {
        if(a[i] != b[i]) cnt++;
        if(cnt > 1) return false;
    }
    if(cnt == 1) return true;
    return false;
}

int solution(string begin, string target, vector<string> words) {
    if(!isTargetInWords(target, words)) return 0;
    queue<node> q;
    vector<int> dist(words.size(), 0);
    q.push({begin,-1});
    vector<bool> isUsed(words.size(), false);
    
    int answer = 0;
    while(!q.empty()) {
        node cur = q.front();
        q.pop();
        
        for(int i=0; i<words.size(); i++) {
            if(isPossible(cur.word, words[i]) && !isUsed[i]) {
                isUsed[i] = true;
                q.push({words[i], i});
                if(cur.idx == -1) dist[i] = 1;
                else dist[i] = dist[cur.idx]+1;
                
                if(words[i] == target) return dist[i];
            }
        }
    }
    
    
    
    return 0;
}