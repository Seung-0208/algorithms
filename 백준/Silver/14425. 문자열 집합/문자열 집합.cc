#include <iostream>
#include <bits/stdc++.h>
#include <climits>

using namespace std;

struct Node {
    Node* children[26];
    bool isEnd;

    Node() {
        for(int i=0; i<26; i++) {
            children[i] = nullptr;
        }
        isEnd = false;
    }
};

int main() {

    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, M;
    cin >> N >> M;    

    Node root;

    for(int i=0; i<N; i++) {
        string line;
        cin >> line;
        Node* cur = &root; //주소
        for(int j=0; j<line.size(); j++) {
            if(cur->children[line[j]-'a'] == nullptr) {
                cur->children[line[j]-'a'] = new Node();
            }
            cur = cur->children[line[j]-'a'];
        }
        cur->isEnd = true;
    }

    int cnt = 0;

    for(int i=0; i<M; i++) {
        string line;
        cin >> line;
        Node* cur = &root;
        bool isExist = true;

        for(int j=0; j<line.size(); j++) {
            if(cur->children[line[j]-'a'] == nullptr) {
                isExist = false;
                break;
            } else {
                cur = cur->children[line[j]-'a'];
            }
        }

        if(isExist && cur->isEnd) cnt++;
    }

    cout << cnt << endl;
    

    return 0;
}