import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer> pre = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        // EOF까지 전위 순회 입력 읽기
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            pre.add(Integer.parseInt(line));
        }

        // 전위 -> 후위 변환
        postOrder(0, pre.size() - 1);

        System.out.print(sb.toString());
    }

    // 전위 순회 구간 [l, r]을 후위 순회로 출력
    static void postOrder(int l, int r) {
        if (l > r) return;

        int root = pre.get(l);
        int idx = l + 1;

        // 오른쪽 서브트리 시작점 찾기 (root보다 큰 첫 위치)
        while (idx <= r && pre.get(idx) < root) {
            idx++;
        }

        // 왼쪽 서브트리
        postOrder(l + 1, idx - 1);
        // 오른쪽 서브트리
        postOrder(idx, r);
        // 루트
        sb.append(root).append('\n');
    }
}
