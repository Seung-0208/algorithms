import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()) - 1;
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(0, N-1);

        sb.append(nums[K]);

        System.out.println(sb);
        br.close();
    }

    static void quickSort(int s, int e) {
        if(s>e) return;
        int pivot = getPivot(s, e);
        if(K < pivot) quickSort(s, pivot-1);
        else if(K > pivot) quickSort(pivot+1, e);
    }

    static int getPivot(int s, int e) {
        int m = (s+e)/2;
        swap(s, m);
        int i = s+1, j = e;
        int pivot = nums[s];

        while(i<=j) {
            while(i<N && nums[i] < pivot) i++;
            while(j>=0 && nums[j] > pivot) j--;
            if(i<=j) swap(i++, j--);
        }

        nums[s] = nums[j];
        nums[j] = pivot;
        return j;
    }

    static void swap (int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}