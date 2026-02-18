import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int temp = 1;
        while(temp <= N) {
            temp *= 2;
        }

        tree = new long[temp*2+1];
        for(int i=0; i<N; i++) {
            tree[temp+i] = Long.parseLong(br.readLine());
        }

        for(int i=temp-1; i>=1; i--) {
            tree[i] = tree[i*2] + tree[i*2+1];
        }

        for(int i=0; i<M+K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a == 1) {
                long c = Long.parseLong(st.nextToken());
                changeTree(b+temp-1, c);
            } else {
                int c = Integer.parseInt(st.nextToken());
                sb.append(calculate(b+temp-1, c+temp-1)).append("\n");
            }
        }

        System.out.println(sb);
    }

    static long calculate(int s, int e) {
        long ans = 0;
        while(s <= e) {
            if(s%2 == 1) {
                ans += tree[s];
                s++;
            }
            if(e%2 == 0) {
                ans += tree[e];
                e--;
            }
            s /= 2;
            e /= 2;
        }
        return ans;
    }

    static void changeTree(int idx, long c) {
        tree[idx] = c;
        idx /= 2;
        while(idx >= 1) {
            tree[idx] = tree[idx*2] + tree[idx*2+1];
            idx /= 2;
        }
    }
}