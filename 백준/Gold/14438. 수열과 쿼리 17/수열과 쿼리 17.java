
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //수의 개수

        int temp = 1;
        while(temp < N) {
            temp *= 2;
        }

        long[] tree = new long[temp*2];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            tree[temp+i] = Long.parseLong(st.nextToken());
        }

        for(int i=temp-1; i>0; i--) {
            tree[i] = Math.min(tree[i*2], tree[i*2+1]);
        }

        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a==1) change(tree, b+temp-1, c);
            else if(a==2) {
                long v = calculate(tree, b+temp-1, (int)(c+temp-1));
                sb.append(v).append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }

    static long calculate(long[] tree, int s, int e) {
        long min = Long.MAX_VALUE;
        while(s <= e) {
            if(s%2 == 1) min = Math.min(min, tree[s]);
            if(e%2 == 0) min = Math.min(min, tree[e]);
            s = (s+1)/2;
            e = (e-1)/2;
        }
        return min;
    }

    static void change(long[] tree, int idx, long num) {
        tree[idx] = num;
        while(idx > 0 && idx/2 > 0) {
            idx = idx/2;
            tree[idx] = Math.min(tree[idx*2], tree[idx*2+1]);
        }
    }
}