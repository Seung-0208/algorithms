import java.io.*;
import java.util.*;

public class Main{
    public static long cnt;
    public static int[] tmp;
    public static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        tmp = new int[N];
        nums = new int[N];
        cnt = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        mergeNSort(0, N-1);
        System.out.println(cnt);
    }
    public static void mergeNSort(int s, int e) {
        if(e-s < 1) return;
        int m = (e+s)/2;
        mergeNSort(s, m);
        mergeNSort(m+1, e);
        for(int i=s; i<=e; i++) tmp[i] = nums[i];
        int idx1 = s, idx2 = m+1;
        int k = s;
        while(idx1 <= m && idx2 <= e) {
            if(tmp[idx1] > tmp[idx2]) {
                nums[k] = tmp[idx2];
                cnt += idx2-k;
                idx2++;
            } else {
                nums[k] = tmp[idx1];
                idx1++;
            }
            k++;
        }
        while(idx1 <= m) {
            nums[k] = tmp[idx1];
            idx1++; k++;
        }
        while(idx2 <= e) {
            nums[k] = tmp[idx2];
            idx2++; k++;
        }
    }
}