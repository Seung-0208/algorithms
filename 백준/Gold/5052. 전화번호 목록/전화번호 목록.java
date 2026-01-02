import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); //전화번호 수
            Node root = new Node();
            boolean isUnique = true;
            for(int i=0; i<n; i++) {
                Node now = root;
                st = new StringTokenizer(br.readLine());
                String tmp = st.nextToken();
                for(int j=0; j<tmp.length(); j++) {
                    char c = tmp.charAt(j);
                    if(now.numbers[c-'0'] == null) {
                        now.numbers[c-'0'] = new Node();
                    } else {
                        if(now.numbers[c-'0'].isLeaf || j==tmp.length()-1) {
                            isUnique = false;
                        }
                    }
                    now = now.numbers[c-'0'];
                    if(j==tmp.length()-1) now.isLeaf = true;
                }
            }
            sb.append(isUnique ? "YES\n" : "NO\n");
        }

        System.out.println(sb);
        br.close();

    }

    static class Node {
        Node[] numbers = new Node[10];
        boolean isLeaf;
    }
}
