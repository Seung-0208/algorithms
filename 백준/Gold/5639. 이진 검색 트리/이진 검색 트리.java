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

        //오른쪽 서브트리의 시작점
        while(idx <= r && order.get(idx) < root) {
            idx++;
        }

        //왼쪽 서브트리
        postOrder(l+1, idx-1);
        //오른쪽 서브트리
        postOrder(idx, r);
        //루트
        sb.append(root).append("\n");
    }
}
