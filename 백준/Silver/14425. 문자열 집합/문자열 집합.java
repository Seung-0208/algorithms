import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); //문자열의 개수
        int M = Integer.parseInt(st.nextToken()); //검사할 문자열의 개수

        Node root = new Node();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();
            Node now = root;
            for(int j=0; j<tmp.length(); j++) {
                char t = tmp.charAt(j);
                if(now.characters[t-'a'] == null) {
                    now.characters[t-'a'] = new Node();
                }
                now = now.characters[t-'a'];
                if(j==tmp.length()-1) {
                    now.isLeaf = true;
                }
            }
        }
        int sum = 0;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();
            Node now = root;
            for(int j=0; j<tmp.length(); j++) {
                char t = tmp.charAt(j);
                now = now.characters[t-'a'];
                if(now == null) break;
                if(j==tmp.length()-1 && now.isLeaf) sum++;
            }
        }

        sb.append(sum);
        System.out.println(sb);
        br.close();

    }

    static class Node {
        Node[] characters = new Node[26];
        boolean isLeaf;
    }
}
