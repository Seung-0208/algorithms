import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph;
    static boolean[][] isVisited;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine()); //지도의 수
        graph = new int[N][N];
        isVisited = new boolean[N][N];
        for(int i=0; i<N; i++) {
            String line = br.readLine();
            for(int j=0; j<N; j++) {
                graph[i][j] = line.charAt(j)-'0';
            }
        }
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(graph[i][j] != 0 && !isVisited[i][j]) {
                    int cnt = BFS(i, j);
                    q.add(cnt);
                }
            }
        }
        sb.append(q.size()).append("\n");
        while(!q.isEmpty()) {
            int cnt = q.poll();
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    static int BFS(int x, int y) {
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(x, y));
        int cnt = 1;
        int[][] point = {{-1, 1, 0, 0}, {0, 0, -1, 1}};
        while(!q.isEmpty()) {
            Point now = q.poll();
            isVisited[now.x][now.y] = true;
            for(int i=0; i<4; i++) {
                int row = now.x + point[0][i];
                int col = now.y + point[1][i];
                if(row >= 0 && row < N && col >= 0 && col < N
                && !isVisited[row][col] && graph[row][col] != 0) {
                    q.add(new Point(row, col));
                    isVisited[row][col] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
