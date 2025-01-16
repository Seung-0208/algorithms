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

        /*
        N의 제곱근까지만 탐색하는 이유 - N의 제곱근까지만 탐색해도 되는 이유
        예를 들어 16의 범위까지의 소수를 구한다고 할 때 16 = 4*4인데 이는 16보다 작은 숫자는 항상 4의 약수를 갖게 된다는 뜻이므로!
        */
        for(int i=2; i<=Math.sqrt(N); i++) {
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
