#include <iostream>
#include <bits/stdc++.h>
#include <climits>

using namespace std;

vector<vector<int>> board;

void preOrder(int node) {
    cout << (char)(node+'A');
    if(board[node][0] != -1) preOrder(board[node][0]);
    if(board[node][1] != -1) preOrder(board[node][1]);
}

void postOrder(int node) {
    if(board[node][0] != -1) postOrder(board[node][0]);
    if(board[node][1] != -1) postOrder(board[node][1]);
    cout << (char)(node+'A');
}

void inOrder(int node) {
    if(board[node][0] != -1) inOrder(board[node][0]);
    cout << (char)(node+'A');
    if(board[node][1] != -1) inOrder(board[node][1]);
}

int main() {

    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;

    board.assign(26, vector<int>(2, -1));

    for(int i=0; i<N; i++) {
        char node, left, right;
        cin >> node >> left >> right;
        if(left != '.') board[node-'A'][0] = left-'A';
        // else board[node-'A'][0] = -1;
        if(right != '.') board[node-'A'][1] = right-'A';
        // else board[node-'A'][1] = -1;
    }

    preOrder(0);
    cout << "\n";
    inOrder(0);
    cout << "\n";
    postOrder(0);
    cout << "\n";
    

    return 0;
}