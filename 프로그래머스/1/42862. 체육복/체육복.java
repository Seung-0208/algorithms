import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n];
        for(int i=0; i<n; i++) students[i] = 1;
        
        for(int r : reserve) {
            students[r-1] += 1;
        }
        Arrays.sort(lost);
        
        for(int l : lost){
            students[l-1] -= 1;
        }
        
        Arrays.sort(reserve);
        
        for(int i=0; i<n ;i++) {
            if(students[i] == 2) {
                //앞에 수가 비어있으면 앞에 먼저 채우기
                if(i-1 >= 0 && students[i-1] == 0) {
                    students[i-1] = 1;
                    students[i] = 1;
                } else if (i+1 < n && students[i+1] == 0) {
                    students[i+1] = 1;
                    students[i] =1;
                }
            }
        }
        
        for(int i=0; i<n; i++) {
            System.out.printf("%d ", students[i]);
        }
        
        
        // for(int r : reserve){
        //     students[r-1]++;
        //     if(students[r-1] == 2) {
        //         //이미 앞에 번호는 체육복 소지한 경우 -> 뒷 번호 검토
        //         if(r-2 >= 0 && students[r-2] > 0 && r < n && students[r] == 0) {
        //             students[r] = 1;
        //             students[r-1] =1;
        //         } else if(r-2 >= 0 && students[r-2] == 0) {
        //             students[r-2] = 1;
        //             students[r-1] = 1;
        //         }
        //     }
        // }
        
        int answer = 0;
        
        for(int i : students) {
            if(i>=1) answer++;
        }
        
        
        return answer;
    }
}