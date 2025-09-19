
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] nums;
    static int[] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        nums = new int[N];
        temp = new int[N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            nums[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, N-1);
        for(int i=0; i<N; i++) {
            bw.write(nums[i]+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void mergeSort(int s, int e) {
        if(s >= e) return;
        int m = (s+e)/2;
        mergeSort(s, m);
        mergeSort(m+1, e);

        for(int i=s; i<=e; i++) temp[i] = nums[i];

        int idx1 = s, idx2 = m+1, k = s;
        while(idx1 <= m && idx2 <= e) {
            if(temp[idx1] < temp[idx2]) {
                nums[k] = temp[idx1];
                idx1++;
            } else {
                nums[k] = temp[idx2];
                idx2++;
            }
            k++;
        }

        while(idx1 <= m) {
            nums[k] = temp[idx1];
            idx1++;
            k++;
        }
        while(idx2 <= e) {
            nums[k] = temp[idx2];
            idx2++;
            k++;
        }
    }
}