import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
        static int[] nums;
        static int K;
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken())-1;

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        partition(0, N-1);
        sb.append(nums[K]);
        System.out.println(sb);
        br.close();
    }

    static void partition(int s, int e) {
        if(s > e) return;
        int pivot = quickSort(s, e);
        if(pivot < K) partition(pivot+1, e);
        else if(pivot > K) partition(s, pivot-1);
    }

    static int quickSort(int s, int e) {
        int m = (s+e)/2;
        swap(s, m);
        int pivot = nums[s];
        int i=s+1, j = e;

        while(i<=j) {
            while(i<=e && nums[i] < pivot) i++;
            while(j>=s && nums[j] > pivot) j--;
            if(i<=j) swap(i++, j--);
        }
        nums[s] = nums[j];
        nums[j] = pivot;
        return j;
    }

    static void swap(int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}