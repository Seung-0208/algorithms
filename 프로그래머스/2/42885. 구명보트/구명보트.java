import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int s = 0, e = people.length-1;
        Arrays.sort(people);
        int answer = 0;
        
        while(s<=e) {
            int temp = people[s]+people[e];
            if(temp <= limit) {
                s++;
                e--;
            } else {
                e--;
            }
            answer++;
        }
        
        return answer;
    }
}