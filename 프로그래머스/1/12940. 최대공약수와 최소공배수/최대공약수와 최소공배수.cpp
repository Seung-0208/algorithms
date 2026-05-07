#include <string>
#include <vector>

using namespace std;

int GCD(int a, int b) {
    int r = 0;
    while(b != 0) {
        r = a % b;
        a = b;
        b = r;
    }
    
    return a;
}

int LCM(int a, int b) {
    int g = GCD(a, b);
    return a/g*b;
}

vector<int> solution(int n, int m) {
    vector<int> answer(2, 0);
    answer[0] = GCD(n, m);
    answer[1] = LCM(n, m);
    return answer;
}