import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            int cnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); //배추밭의 가로길이
            int N = Integer.parseInt(st.nextToken()); //배추밭의 세로길이
            int[][] arr = new int[N][M];
            isVisited = new boolean[N][M];
            int K = Integer.parseInt(st.nextToken()); //배추의 개수
            for(int k=0; k<K; k++) {
                st = new StringTokenizer(br.readLine());
                int col = Integer.parseInt(st.nextToken());
                int row = Integer.parseInt(st.nextToken());
                arr[row][col] = 1;
            }

            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(!isVisited[i][j] && arr[i][j] == 1) {
                        BFS(arr, new Node(i,j), N, M);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    static void BFS(int[][] arr, Node node, int row, int col) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        isVisited[node.row][node.col] = true;
        int[][] point = {{0,0,-1,1}, {-1,1,0,0}};
        while(!q.isEmpty()) {
            Node curr = q.poll();
            for(int i=0; i<4; i++) {
                int newRow = curr.row + point[0][i];
                int newCol = curr.col + point[1][i];
                if(newRow >= 0 && newRow < row && newCol >=0 && newCol < col &&
                        !isVisited[newRow][newCol] && arr[newRow][newCol] == 1) {
                    q.add(new Node(newRow, newCol));
                    isVisited[newRow][newCol] = true;
                }
            }
        }
    }

    static class Node {
        int row;
        int col;
        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}