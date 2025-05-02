
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //문자열의 개수 N(S)
        int M = Integer.parseInt(st.nextToken()); //문자열의 개수 M

        Node root = new Node();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();
            Node now = root;
            for(int j=0; j<tmp.length(); j++) {
                char c = tmp.charAt(j);
                if(now.children[c-'a'] == null) {
                    now.children[c-'a'] = new Node();
                }
                now = now.children[c-'a'];
                if(j == tmp.length()-1) now.isLeaf = true;
            }
        }

        int cnt = 0;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();
            Node now = root;
            for(int j=0; j<tmp.length(); j++) {
                char c = tmp.charAt(j);
                if(now.children[c-'a'] == null) break;
                now = now.children[c-'a'];
                if(j == tmp.length()-1 && now.isLeaf) cnt++;
            }
        }
        bw.write(cnt+"\n");
        bw.flush();
    }

    static class Node {
        Node[] children = new Node[26];
        boolean isLeaf;
    }
}