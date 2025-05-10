
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
        int K = Integer.parseInt(st.nextToken()); //구간의 합을 구하는 횟수

        int length = N;
        int treeHeight = 0;
        while(length > 0) {
            treeHeight++;
            length /= 2;
        }
        if((int)Math.pow(2, treeHeight-1) == N) treeHeight--;
        int treeSize = (int)Math.pow(2,treeHeight+1);
        int treeLeafStart = treeSize/2;
        tree = new long[treeSize];
        for(int i=treeLeafStart; i <= treeLeafStart+N-1; i++) {
            st = new StringTokenizer(br.readLine());
            tree[i] = Long.parseLong(st.nextToken());
        }

        fillTree(treeLeafStart - 1);
        for(int i=0; i<M+K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if(a==1) {
                b = b + treeLeafStart - 1;
                changeNode(b, c);
            }
            else if(a==2) {
                long result = getPartSum(b, (int) c, treeLeafStart);
                bw.write(result+"\n");
            }
        }

        bw.flush();
        br.close();
    }

    static void fillTree(int i) {
        while(i > 0) {
            tree[i] = tree[2*i] + tree[2*i + 1];
            i--;
        }
    }

    static void changeNode(int idx, long val) {
        long interval = val - tree[idx];
        while(idx > 0) {
            tree[idx] += interval;
            idx /= 2;
        }
    }

    static long getPartSum(int start, int end, int leafNodeStart) {
        //주어진 인덱스를 세그먼트 트리 인덱스로 변경
        start = start + leafNodeStart - 1;
        end = end + leafNodeStart - 1;
        long ret = 0;
        while(start <= end) {
            if(start%2==1) {
                ret += tree[start];
                start++;
            }
            if(end%2==0) {
                ret += tree[end];
                end--;
            }
            start/=2;
            end/=2;
        }
        return ret;
    }
}