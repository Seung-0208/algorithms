import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] nums;
    static int[] copyNums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
//        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        copyNums = new int[N];
        for(int i=0; i<N; i++) nums[i] = Integer.parseInt(br.readLine());

        mergeSort(0, N-1);
        for(int i=0; i<N; i++) sb.append(nums[i]).append("\n");
        System.out.println(sb);
        br.close();
    }

    static void mergeSort(int s, int e) {
        if(s >= e) return;

        int m = (s+e)/2;
        mergeSort(s, m);
        mergeSort(m+1, e);

        System.arraycopy(nums, s, copyNums, s, e-s+1);

        int i = s, j = m+1;
        int k = s;

        while(i < j && i<=m && j<=e) {
            if(copyNums[i] < copyNums[j]) {
                nums[k] = copyNums[i];
                i++;
            }
            else {
                nums[k] = copyNums[j];
                j++;
            }
            k++;
        }

        while(i<=m) {
            nums[k] = copyNums[i];
            k++; i++;
        }

        while(j<=e) {
            nums[k] = copyNums[j];
            k++; j++;
        }
    }
}