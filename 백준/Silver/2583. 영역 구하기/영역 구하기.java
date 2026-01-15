
import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] isVisited;
    static int[] answers;
    static int[][] guide = {{0,0,-1,1}, {-1,1,0,0}};
    static int M, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); //행
        N = Integer.parseInt(st.nextToken()); //열
        map = new int[M][N];
        isVisited = new boolean[M][N];
        int K = Integer.parseInt(st.nextToken()); //직사각형 개수
        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int leftX = Integer.parseInt(st.nextToken()); //열
            int leftY = Integer.parseInt(st.nextToken()); //행
            int rightX = Integer.parseInt(st.nextToken());
            int rightY = Integer.parseInt(st.nextToken());
            //M-leftY+1, leftX는 그대로, rightX-1
            for(int row=M-rightY; row<=M-leftY-1; row++) {
                for(int col=leftX; col<=rightX-1; col++) {
                    map[row][col] = -1;
                }
            }
        }
        int idx=1;
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(!isVisited[i][j] && map[i][j] != -1) {
                    map[i][j] = idx;
                    DFS(i, j);
                    idx++;
                }
            }
        }
        answers = new int[idx];
        sb.append(idx-1).append("\n");
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] != -1) answers[map[i][j]]++;
            }
        }
        Arrays.sort(answers);
        for(Integer a : answers){
            if(a != 0) sb.append(a).append(" ");
        }
        System.out.println(sb);
        br.close();
    }

    static void DFS(int row, int col) {
        isVisited[row][col] = true;
        for(int i=0; i<4; i++) {
            int newRow = row+guide[0][i], newCol = col+guide[1][i];
            if(newRow >= 0 && newRow < M && newCol >= 0 && newCol < N) {
                if(map[newRow][newCol] != -1 && !isVisited[newRow][newCol]) {
                    isVisited[newRow][newCol] = true;
                    map[newRow][newCol] = map[row][col];
                    DFS(newRow, newCol);
                }
            }
        }
    }

    static class Node {
        int row, col;
        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}