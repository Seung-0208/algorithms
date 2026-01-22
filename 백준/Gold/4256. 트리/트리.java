
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int t=0; t<T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] preOrder = new int[n+1]; //전위 순회 결과
            int[] inOrder = new int[n+1]; //중위 순회 결과
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++) {
                preOrder[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++) {
                inOrder[i] = Integer.parseInt(st.nextToken());
            }
            getTreeInfo(preOrder, inOrder, 1, 1, n, sb);
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    static void getTreeInfo(int[] preOrder, int[] inOrder, int pIdx, int s, int e, StringBuilder sb) {
        if(pIdx > preOrder.length || s > e) return;

        int root = preOrder[pIdx];
        int partition = 0;
        for(int i=s; i<=e;  i++) {
            if(root == inOrder[i]) partition = i;
        }
        getTreeInfo(preOrder, inOrder, pIdx+1, s, partition-1, sb);
        getTreeInfo(preOrder, inOrder, pIdx+(partition-s+1), partition+1, e, sb);
        sb.append(root).append(" ");
    }
}
