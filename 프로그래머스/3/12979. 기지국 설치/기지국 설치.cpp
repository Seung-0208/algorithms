#include <iostream>
#include <vector>
using namespace std;

int solution(int n, vector<int> stations, int w)
{
    int answer = 0;

    int s = 0, e = 0;
    int dist = w*2 + 1;
    for(int station : stations){
        s = station - w;
        
        if(s < 0) s = 0;
        answer += (s-e-1+dist-1)/dist;
        e = station + w;
    }
    
    if(e < n) {
        answer += (n-e+dist-1)/dist;
    }

    return answer;
}