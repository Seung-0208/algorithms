#include <iostream>

using namespace std;

int main() {
    int N;
    cin >> N;

    int nums[N];

    for(int i=0; i<N; i++) {
        cin >> nums[i];
    }

    for(int i=N-1; i>=0; i--) {
        for(int j=0; j<i; j++) {
            if(nums[j] > nums[j+1]) {
                int temp = nums[j];
                nums[j] = nums[j+1];
                nums[j+1] = temp;
            }
        }
    }

    for(int i=0; i<N; i++) {
        cout << nums[i] << endl;
    }

    return 0;
}