import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        long[] nums = new long[10000001];

        for(int i=2; i<=10000000; i++) {
            nums[i] = 1;
        }
        //소수 구하기
        for(int i=2; i<Math.sqrt(nums.length); i++) {
            if(nums[i] == 1) {
                int temp = 2;
                int j = temp * i;
                while(j<nums.length) {
                    nums[j] = 0;
                    temp++;
                    j = temp*i;
                }
            }
        }
        //거의 소수 구하기
        int cnt = 0;
        for(int i=2; i<nums.length; i++) {
            if(nums[i]==1) { //i번째 값이 1이면 소수
                long temp = i;
                //이때 N^k와 B값이 아닌 N과 B/N^(k-1)을 비교 -> 이항정리
                while((double)i <= (double)B/(double)temp) {
                    if((double)i >= (double)A/(double)temp) cnt++;
                    temp = temp*i;
                }
            }
        }

        System.out.println(cnt);
    }
}
