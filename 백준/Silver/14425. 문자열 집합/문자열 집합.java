
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Node root = new Node();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();
            Node now = root;
            for(int j=0; j<tmp.length(); j++) {
                char t = tmp.charAt(j);
                if(now.children[t-'a'] == null) {
                    now.children[t-'a'] = new Node();
                }
                now = now.children[t-'a'];
                if(j == tmp.length()-1) now.isLeaf = true;
            }
        }
        int cnt = 0;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();
            Node now = root;
            for(int j=0; j<tmp.length(); j++) {
                char t = tmp.charAt(j);
                if(now.children[t-'a'] == null) break;
                now = now.children[t-'a'];
                if(j==tmp.length()-1 && now.isLeaf) cnt++;
            }
        }

        bw.write(cnt+"\n");
        bw.flush();

    }

    static class Node{
        Node[] children = new Node[26];
        boolean isLeaf;
    }

}