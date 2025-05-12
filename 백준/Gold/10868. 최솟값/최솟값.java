
import java.io.*;
import java.util.*;

public class Main {
    static int[] tree;
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int length = N;
        int treeHeight = 0;
        while(length!=0) {
            treeHeight++;
            length /= 2;
        }

        if((int)Math.pow(2, treeHeight-1) == N) treeHeight--;
        int leafNodeStart = (int)Math.pow(2, treeHeight);
        int treeSize = leafNodeStart*2;

        tree = new int[treeSize];
        for(int i=0; i<treeSize; i++) tree[i] = Integer.MAX_VALUE;
        for(int i=leafNodeStart; i<leafNodeStart+N; i++) {
            st = new StringTokenizer(br.readLine());
            tree[i] = Integer.parseInt(st.nextToken());
        }

        fillTree(leafNodeStart-1);

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            a = a + leafNodeStart - 1;
            b = b + leafNodeStart - 1;
            bw.write(checkLeastNum(a, b)+"\n");
        }

        bw.flush();

    }

    static void fillTree(int i) {
        while(i > 0) {
            tree[i] = Math.min(tree[i*2], tree[i*2+1]);
            i--;
        }
    }

    static int checkLeastNum(int start, int end) {
        int ans = Integer.MAX_VALUE;
        while(start <= end) {
            if(start % 2 == 1) {
                if(ans > tree[start]) ans = tree[start];
                start++;
            }
            if(end % 2 == 0) {
                if(ans > tree[end]) ans = tree[end];
                end--;
            }
            start /= 2;
            end /= 2;
        }
        return ans;
    }
}