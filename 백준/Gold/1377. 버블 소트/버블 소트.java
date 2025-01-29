import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Data[] nums = new Data[N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int tmp = Integer.parseInt(st.nextToken());
            nums[i] = new Data(tmp, i);
        }
        Arrays.sort(nums);

        int max = 0;
        for(int i=0; i<N; i++) {
            int gap = nums[i].idx - i;
            if(gap > max) max = gap;
        }

        bw.write(String.valueOf(max+1));
        bw.flush();
    }

    static class Data implements Comparable<Data>{
        int value;
        int idx;
        public Data(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }

        @Override
        public int compareTo(Data o) {
            return this.value - o.value;
        }
    }
}