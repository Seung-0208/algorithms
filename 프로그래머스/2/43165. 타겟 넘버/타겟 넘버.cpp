#include <string>
#include <vector>

using namespace std;

int N;
int cnt;

void tracking(int idx, int total, const int target, const vector<int>& numbers) {
    if(idx == N) {
       if(total == target) cnt++;
        return;
    }
    
    //음수를 붙였을 때
    tracking(idx+1, total-numbers[idx], target, numbers);
    
    //양수를 붙였을 때
    tracking(idx+1, total+numbers[idx], target, numbers);
}

int solution(vector<int> numbers, int target) {
    N = numbers.size();
    tracking(0, 0, target, numbers);
    int answer = cnt;
    return answer;
}