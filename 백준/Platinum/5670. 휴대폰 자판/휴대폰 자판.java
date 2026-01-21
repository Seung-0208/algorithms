
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        while((line = br.readLine()) != null && !line.isEmpty()) {
            int N = Integer.parseInt(line);
            Node graph = new Node();
            int[] cnt = new int[N];
            String[] words = new String[N];
            for(int i=0; i<N; i++) {
                String temp = br.readLine();
                words[i] = temp;
                Node curr = graph;
                for(char c : temp.toCharArray()) {
                    if(curr.child[c-'a'] == null) curr.child[c-'a'] = new Node();
                    curr = curr.child[c-'a'];
                }
                curr.isLeaf = true;
            }

            for(int i=0; i<N; i++) {
                int idx = 0;
                Node curr = new Node();
                for(char c : words[i].toCharArray()) {
                    if(idx == 0) {
                        cnt[i]++;
                        idx = 1;
                        curr = graph.child[c-'a'];
                    } else {
                        int childCnt =countNotNull(curr.child);
                        if(childCnt > 1) {
                            cnt[i]++;
                        } else if(childCnt == 1 && curr.isLeaf) {
                            cnt[i]++;
                        }
                        curr = curr.child[c-'a'];
                    }
                }
            }
            sb.append(getAvg(cnt)).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    static class Node {
        Node[] child = new Node[26];
        boolean isLeaf;
    }

    static String getAvg(int[] count) {
        double sum = 0;
        for(int c : count) {
            sum += c;
        }
        return String.format("%.2f", ((double)sum/count.length));
    }

    static int countNotNull(Node[] child) {
        int cnt = 0;
        for(Node n:child) {
            if(n != null) cnt++;
        }
        return cnt;
    }
}
