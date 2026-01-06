import java.io.*;
import java.util.*;

public class Main {
    static long[] tree;
    static int leafNodeStart;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); //수의 개수
        int Q = Integer.parseInt(st.nextToken()); //턴의 개수

        leafNodeStart = 1;
        while(leafNodeStart < N) {
            leafNodeStart *= 2;
        }
        int treeSize = leafNodeStart * 2;
        tree = new long[treeSize];

        //초기화
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            tree[i+leafNodeStart] = Integer.parseInt(st.nextToken());
        }
        for(int i=leafNodeStart-1; i>0; i--) {
            tree[i] = tree[i*2]+tree[i*2+1];
        }

        for(int i=0; i<Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(getSum(Math.min(x,y), Math.max(x,y))).append("\n");
            changeNum(a, b);
        }

        System.out.println(sb);
        br.close();
    }

    static long getSum(int x, int y) {
        int start = leafNodeStart - 1 + x;
        int end = leafNodeStart - 1 + y;
        long total = 0;
        while(start <= end) {
            if(start % 2 == 1) total += tree[start];
            if(end %2 == 0) total += tree[end];
            start = (start + 1)/2;
            end = (end-1)/2;
        }
        return total;
    }

    static void changeNum(int idx, long num) {
        idx = leafNodeStart - 1 + idx;
        tree[idx] = num;
        while(true) {
            idx /= 2;
            if(idx == 0) break;
            tree[idx] = tree[idx*2] + tree[idx*2+1];
        }
    }
}
