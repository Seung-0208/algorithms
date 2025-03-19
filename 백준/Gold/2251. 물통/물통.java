import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main{
    static boolean[][] visited = new boolean[201][201]; //C는 제외
    static int[] total = new int[3]; //A, B, C 총량
    static int[] sender = {0, 0, 1, 1, 2, 2}; //경우의 수
    static int[] receiver = {1, 2, 0, 2, 0, 1};
    static boolean[] ans = new boolean[201];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<3; i++) {
            total[i] = Integer.parseInt(st.nextToken());
        }
        BFS();
        for(int i=0 ; i<201; i++) {
            if(ans[i]) bw.write(String.valueOf(i)+" ");
        }
        bw.flush();
    }
    static void BFS() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0)); //C에만 물이 차 있는 경우
        visited[0][0] = true;//빠뜨림
        ans[total[2]] = true;

        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            int A = curr.A;
            int B = curr.B;
            int C = total[2] - A- B;
            for(int i=0; i<6; i++) {
                int[] water = {A, B, C}; //water 배열 정의하는 부분은 반복문 안에 있어야 함..
                water[receiver[i]] += water[sender[i]];
                water[sender[i]] = 0;
                if(total[receiver[i]] < water[receiver[i]]) { //넘치는 경우
                    water[sender[i]] = water[receiver[i]] - total[receiver[i]];
                    water[receiver[i]] = total[receiver[i]];
                }
                if(!visited[water[0]][water[1]]) {
                    visited[water[0]][water[1]] = true;
                    queue.add(new Node(water[0], water[1]));
                    if(water[0]==0) {
                        ans[water[2]] = true;
                    }
                }
            }
        }
    }

    static class Node {
        int A; int B;

        public Node(int a, int b) {
            A = a;
            B = b;
        }
    }
}