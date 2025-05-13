
import java.io.*;
import java.util.*;

public class Main {
    static long[] tree;
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //수의 개수
        int M = Integer.parseInt(st.nextToken()); //수의 변경 횟수
        int K = Integer.parseInt(st.nextToken()); //구간의 곱을 구하는 횟수

        //tree 초기화
        int treeHeight = 0;
        int length = N;
        while(length>0) {
            length /= 2;
            treeHeight++;
        }
        if((int)Math.pow(2, treeHeight-1)==N) treeHeight--;
        int leafNodeStart = (int) Math.pow(2, treeHeight);
        int treeSize = leafNodeStart*2;
        tree = new long[treeSize];
        for(int i=1; i<treeSize; i++) tree[i] = 1;

        for(int i=leafNodeStart; i<leafNodeStart+N; i++) {
            st = new StringTokenizer(br.readLine());
            tree[i] = Long.parseLong(st.nextToken());
        }

        fillTree(leafNodeStart-1);

        for(int i=0; i < M+K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            b = b+leafNodeStart-1;
            if(a==1) {
                changeNode(b, c);
            }
            else {
                c = c+leafNodeStart-1;
                long ret = getValue(b, (int) c);
                bw.write(ret+"\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();

    }

    static void fillTree(int i) {
        while(i > 0) {
            if(tree[i*2]*tree[i*2+1] == 0) tree[i] = 0;
            else tree[i] = tree[i*2]*tree[i*2+1] % 1000000007;
            i--;
        }
    }

    static void changeNode(int idx, long val) {
        tree[idx] = val;
        while(idx/2>0) {
            tree[idx/2] = (tree[idx/2*2+1]*tree[idx/2*2])%1000000007;
            idx /= 2;
        }
    }

    static long getValue(int s, int e) {
        long ret = 1;
        while(s <= e) {
            if(s%2==1) {
                if(ret * tree[s] == 0) ret = 0;
                else ret = ret * tree[s] % 1000000007;
                s++;
            }
            if(e%2==0) {
                if(ret * tree[e] == 0) ret = 0;
                else ret = ret * tree[e] % 1000000007;
                e--;
            }
            s /= 2;
            e /= 2;
        }
        return ret;
    }
}