import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][][] distance;
    static boolean[][][] isVisited;
    static int[][] guide = {{0,0,-1,1}, {1,-1,0,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        distance = new int[N][M][2];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                distance[i][j][0] = Integer.MAX_VALUE;
                distance[i][j][1] = Integer.MAX_VALUE;
            }
        }
        isVisited = new boolean[N][M][2];

        map = new int[N][M];

        for(int i=0; i<N; i++) {
            char[] nums = br.readLine().toCharArray();
            int idx = 0;
            for(char n : nums) {
                map[i][idx] = n-'0';
                idx++;
            }
        }

        visit();

        if(!isVisited[N-1][M-1][0] && !isVisited[N-1][M-1][1]) {
            sb.append("-1");
        } else {
            sb.append(Math.min(distance[N-1][M-1][0], distance[N-1][M-1][1]));
        }



        System.out.println(sb);
        br.close();
    }

    static void visit() {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(0, 0, false));
        isVisited[0][0][0] = true;
        distance[0][0][0] = 1;
        while(!q.isEmpty()) {
            Node cur = q.poll();
            for(int i=0; i<4; i++) {
                int nr = cur.r + guide[0][i];
                int nc = cur.c + guide[1][i];
                boolean nIsCracked = cur.isCracked;
                if(!(nr >= 0 && nr < N && nc >= 0 && nc < M)) continue;
                if(map[nr][nc] == 0) {
                    if(!nIsCracked && !isVisited[nr][nc][0]) {
                        isVisited[nr][nc][0] = true;
                        distance[nr][nc][0] = distance[cur.r][cur.c][0] + 1;
                        q.add(new Node(nr, nc, false));
                    } else if(nIsCracked && !isVisited[nr][nc][1]) {
                        isVisited[nr][nc][1] = true;
                        distance[nr][nc][1] = distance[cur.r][cur.c][1] + 1;
                        q.add(new Node(nr, nc, true));
                    }
                } else if(map[nr][nc] != 0 && !nIsCracked && !isVisited[nr][nc][1]) {
                    isVisited[nr][nc][1] = true;
                    distance[nr][nc][1] = distance[cur.r][cur.c][0] + 1;
                    q.add(new Node(nr, nc, true));
                }
            }
        }
    }

    static class Node {
        int r, c;
        boolean isCracked;
        public Node(int r, int c, boolean isCracked) {
            this.r = r;
            this.c = c;
            this.isCracked = isCracked;
        }
    }
}