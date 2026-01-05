import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> order = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while((line = br.readLine()) != null && !line.isEmpty()) {
            order.add(Integer.parseInt(line));
        }

        postOrder(0, order.size()-1);

        System.out.println(sb);
        br.close();

    }

    static void postOrder(int l, int r) {
        if(l > r) return;

        int root = order.get(l);
        int idx = l+1;

        while(idx <= r && root > order.get(idx)) {
            idx++;
        }

        postOrder(l+1, idx-1);
        postOrder(idx, r);
        sb.append(root).append("\n");
    }
}
