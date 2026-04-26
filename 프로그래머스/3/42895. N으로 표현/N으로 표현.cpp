#include <string>
#include <vector>

using namespace std;

int makeRepeatNumber(int N, int cnt) {
    string t = "";
    for(int i=0; i<cnt; i++) {
        t += to_string(N);
    }
    return stoi(t);
}

int solution(int N, int number) {
    vector<vector<int>> cnt(9, vector<int>());
    
    for(int i=1; i<=8; i++) {
        int temp = makeRepeatNumber(N, i);
        if(temp == number) return i;
        cnt[i].push_back(temp);
    }
    
    for(int i=2; i<=8; i++) {
        for(int j=1; j<=i/2; j++) {
            for(int a : cnt[j]) {
                for(int b : cnt[i-j]) {
                    int temp = a+b;
                    if(temp == number) return i;
                    cnt[i].push_back(temp);
                    
                    temp = a*b;
                    if(temp == number) return i;
                    cnt[i].push_back(temp);
                    
                    temp = a-b;
                    if(temp == number) return i;
                    cnt[i].push_back(temp);
                    
                    temp = b-a;
                    if(temp == number) return i;
                    cnt[i].push_back(temp);
                    
                    if(b != 0) {
                        temp = a/b;
                        if(temp == number) return i;
                        cnt[i].push_back(temp);   
                    }
                    
                    if(a != 0) {
                        temp = b/a;
                        if(temp == number) return i;
                        cnt[i].push_back(temp);   
                    }
                }
            }
        }
    }
    
    return -1;
}