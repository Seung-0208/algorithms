import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        boolean[] nums = new boolean[N+1];

        for(int i=2; i<=N; i++) {
            nums[i] = true;
        }

        for(int i=2; i<=N; i++) {
            if(nums[i]) {
                int temp = 2;
                int j = i * temp;
                while (j <= N) {
                    nums[j] = false;
                    temp++;
                    j = i * temp;
                }
            }
        }
        for(int i=M; i<=N; i++) {
            if(nums[i]) System.out.println(i);
        }
    }
}