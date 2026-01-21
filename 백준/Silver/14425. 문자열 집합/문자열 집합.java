
import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    Map<String, Boolean> isUsed = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Node graph = new Node();
        for(int i=0; i<N; i++) {
            String line = br.readLine();
            Node curr = graph;
            for(char c : line.toCharArray()) {
                if(curr.child[c-'a'] == null) curr.child[c-'a'] = new Node();
                curr = curr.child[c-'a'];
            }
            curr.isLeaf = true;
        }

        int cnt = 0;
        for(int i=0; i<M; i++) {
            String line = br.readLine();
            boolean isExist = true;
            Node curr = graph;
            for(char c : line.toCharArray()) {
                if(curr.child[c-'a'] == null) {
                    isExist = false;
                    break;
                }
                curr = curr.child[c-'a'];
            }
            if(!curr.isLeaf) isExist = false;
            if(isExist) cnt++;
        }

        sb.append(cnt);

        System.out.println(sb);
        br.close();
    }

    static class Node{
        Node[] child = new Node[26];
        boolean isLeaf;
    }
}
