import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
        static int N;
        static int[] nums;
        static int[] copy;
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        copy = new int[N];

        for(int i=0; i<N; i++ ) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(0, N-1);

        for(int t : nums) sb.append(t).append("\n");
        System.out.println(sb);
        br.close();
    }

    static void mergeSort(int s, int e){
        if(s >= e) return;

        int m = (s+e)/2;
        mergeSort(s, m);
        mergeSort(m+1, e);

        System.arraycopy(nums, s, copy, s, (e-s)+1);

        int i=s, j=m+1;
        int k=s;

        while(i<=m && j<=e) {
            if(copy[i] < copy[j]) {
                nums[k] = copy[i];
                i++;
            } else {
                nums[k] = copy[j];
                j++;
            }
            k++;
        }

        while(i<=m) {
            nums[k] = copy[i];
            i++;
            k++;
        }

        while(j<=e) {
            nums[k] = copy[j];
            j++;
            k++;
        }
    }
}