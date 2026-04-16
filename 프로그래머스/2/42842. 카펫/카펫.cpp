#include <string>
#include <vector>

using namespace std;

vector<int> solution(int brown, int yellow) {
    brown -= 4;
    int whSum = brown / 2;
    int h = 1, w = whSum - h;
    
    while(w >= h) {
        if(w*h == yellow) break;
        else {
            w--;
            h++;
        }
    }
    
    vector<int> answer = {w+2, h+2};
    return answer;
}