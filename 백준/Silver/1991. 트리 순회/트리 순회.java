import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] tree = new int['Z'-'A'+1][2];;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            char node = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if(left != '.') tree[node-'A'][0] = left-'A';
            if(right != '.') tree[node-'A'][1] = right-'A';
        }

        preOrder(0);
        sb.append("\n");
        order(0);
        sb.append("\n");
        postOrder(0);

        System.out.println(sb);
    }

    static void preOrder(int node) {
        sb.append((char)(node+'A'));
        if(tree[node][0] != 0) preOrder(tree[node][0]);
        if(tree[node][1] != 0) preOrder(tree[node][1]);
    }

    static void postOrder(int node) {
        if(tree[node][0] != 0) postOrder(tree[node][0]);
        if(tree[node][1] != 0) postOrder(tree[node][1]);
        sb.append((char)(node+'A'));
    }

    static void order(int node) {
        if(tree[node][0] != 0) order(tree[node][0]);
        sb.append((char)(node+'A'));
        if(tree[node][1] != 0) order(tree[node][1]);
    }
}