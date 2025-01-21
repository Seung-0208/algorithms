import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[10000001];
        for(int i=0; i<nums.length; i++) nums[i] = i;
        //소수 판정
        for(int i=2; i<Math.sqrt(nums.length); i++) {
            if(nums[i] != 0) {
                int temp = 2;
                int j = i * temp;
                while(j<=10000000) {
                    nums[j] = 0;
                    temp++;
                    j = i*temp;
                }
            }
        }

        while(true) {
            if(nums[N] != 0) {
                String numberString = Integer.toString(N);
                char[] temp = numberString.toCharArray();
                int start = 0, end = temp.length-1;
                boolean isSame = true;
                while(start <= end) {
                    if(temp[start] != temp[end]) {
                        isSame = false;
                        break;
                    }
                    start++; end--;
                }
                if(isSame) break;
            }
            N++;
        }
        if(N==1) System.out.println(2);
        else System.out.println(N);
    }
}