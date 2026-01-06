import java.io.*;
import java.util.*;

public class Main {
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); //수의 개수
        int M = Integer.parseInt(st.nextToken()); //수의 변경 횟수
        int K = Integer.parseInt(st.nextToken()); //구간의 합 횟수

        int leafStartIdx = 1;
        while(leafStartIdx < N) {
            leafStartIdx *= 2;
        }
        int treeSize = leafStartIdx * 2;
        tree = new long[treeSize];

        // 트리 초기화
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            tree[i+leafStartIdx] = Long.parseLong(st.nextToken());
        }
        for(int i=leafStartIdx-1; i>0; i--) {
            tree[i] = tree[i*2] + tree[i*2+1];
        }

        for(int i=0; i<M+K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a==1) {
                long c = Long.parseLong(st.nextToken());
                b += (leafStartIdx-1);
                tree[b] = c;
                while(true) {
                    b /= 2;
                    if(b==0) break;
                    tree[b] = tree[b*2] + tree[b*2+1];
                }
            }
            if(a==2) {
                int c = Integer.parseInt(st.nextToken());
                int start = b + (leafStartIdx-1);
                int end = c + (leafStartIdx-1);
                long total = 0;

                while(start <= end) {
                    if(start % 2 == 1) total += tree[start];
                    if(end % 2 == 0) total += tree[end];
                    start = (start+1)/2;
                    end = (end-1)/2;
                }

                sb.append(total).append("\n");
            }
        }
        System.out.println(sb);
        br.close();
    }
}
