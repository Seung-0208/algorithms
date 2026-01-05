import java.io.*;
import java.util.*;

public class Main {
    static String tmp = "";
    static int[][] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        tree = new int[N+1][2];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int root = st.nextToken().charAt(0) - 'A' + 1;
            int left = st.nextToken().charAt(0) - 'A' + 1;
            if(left >= 0) tree[root][0] = left;
            int right = st.nextToken().charAt(0) - 'A' + 1;
            if(right >= 0) tree[root][1] = right;
        }

        preorder(1);
        sb.append(tmp).append("\n");
        tmp = "";
        inorder(1);
        sb.append(tmp).append("\n");
        tmp = "";
        postorder(1);
        sb.append(tmp);

        System.out.println(sb);
        br.close();

    }

    static void preorder(int root) {
        if(root == 0) return;
        tmp += String.valueOf((char)(root+'A'-1));
        preorder(tree[root][0]);
        preorder(tree[root][1]);
    }

    static void inorder(int root) {
        if(root == 0) return;
        inorder(tree[root][0]);
        tmp += String.valueOf((char)(root+'A'-1));
        inorder(tree[root][1]);
    }

    static void postorder(int root) {
        if(root == 0) return;
        postorder(tree[root][0]);
        postorder(tree[root][1]);
        tmp += String.valueOf((char)(root+'A'-1));
    }
}
