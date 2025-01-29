import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        //값 입력받기
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int[] tmp = new int[N];
        mergeNsrot(tmp, nums, 0, N-1);
        for(int n : nums) {
            bw.write(String.valueOf(n)+"\n");
        }
        bw.flush();
    }
    public static void mergeNsrot(int[]tmp, int[]nums, int s, int e) {
        if(e-s<1) return;
        int m = (s+e)/2;
        mergeNsrot(tmp, nums, s,m);
        mergeNsrot(tmp, nums, m+1, e);
        for(int i=s; i<=e; i++) tmp[i] = nums[i];
        int k = s; //k는 원래 배열에 값을 덮어쓰기 위한 값
        int idx1 = s, idx2 = m+1;
        while(idx1 <= m && idx2 <= e) {
            if(tmp[idx1] < tmp[idx2]) {
                nums[k] = tmp[idx1];
                idx1++;
            }
            else {
                nums[k] = tmp[idx2];
                idx2++;
            }
            k++;
        }
        while(idx1 <= m) {
            nums[k] = tmp[idx1];
            k++;
            idx1++;
        }
        while(idx2 <= e) {
            nums[k] = tmp[idx2];
            k++;
            idx2++;
        }
    }
}
