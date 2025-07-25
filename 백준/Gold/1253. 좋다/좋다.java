import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long[] nums = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) nums[i] = Long.parseLong(st.nextToken());
        Arrays.sort(nums); //0번
        int cnt = 0;
        for(int i=0; i<N; i++) { //1번
            int s_pt = 0, e_pt = N-1;
            long cur = nums[i];
            while(s_pt<e_pt) { //2번
                long temp = nums[s_pt] + nums[e_pt];
                if(cur > temp) s_pt++;
                else if(cur < temp) e_pt--;
                else { //만약 둘이 같다면
                    if(s_pt != i && e_pt != i) {
                        cnt++;
                        break;
                    }
                    else if(s_pt==i) s_pt++;
                    if(e_pt==i) e_pt--;
                }
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}