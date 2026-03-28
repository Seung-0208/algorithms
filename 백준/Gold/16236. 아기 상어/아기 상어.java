import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int [][] map;
    static int N;
    static int[][] guide = {{1,-1,0,0}, {0,0,1,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;
        int sr=0, sc = 0;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9) {
                    sr = i;
                    sc = j;
                    map[i][j] = 0;
                }
            }
        }
        int size = 2;
        int answer = 0;
        int cnt = 0;
        Result next = new Result(sr, sc, 0);
        while(true) {
            next = calculate(next.r, next.c, size);
            if(next == null) break;

            answer += next.dist;
            cnt++;
            if(cnt == size) {
                size++;
                cnt = 0;
            }
        }

        sb.append(answer);
        System.out.println(sb);
    }

    static Result calculate(int r, int c, int size) {
        //거리가 같은 물고기들 저장소
        PriorityQueue<int[]> saved = new PriorityQueue<>(
                (a,b) -> {
                    if(a[0] != b[0]) return a[0]-b[0];
                    return a[1]-b[1];
                }
        );

        //BFS 용 큐
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {r,c});
        boolean[][] isVisited = new boolean[N][N];
        int[][] distance = new int[N][N];
        int minDist = Integer.MAX_VALUE;
        distance[r][c] = 0;
        isVisited[r][c] = true;
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            for(int i=0; i<4; i++) {
                int nr = curr[0]+guide[0][i];
                int nc = curr[1]+guide[1][i];
                if(nr>=0 && nr<N && nc>=0 && nc<N && !isVisited[nr][nc]) {
                    isVisited[nr][nc] = true;
                    distance[nr][nc] = distance[curr[0]][curr[1]]+1;
                    if(map[nr][nc] == 0 || map[nr][nc] == size) {
                        q.add(new int[]{nr, nc});
                    }
                    else if(map[nr][nc] < size){
                        if(distance[nr][nc] <= minDist) {
                            minDist = distance[nr][nc];
                            saved.add(new int[] {nr, nc});
                        }
                    }
                }
            }
        }
        if(saved.isEmpty()) return null;

        int[] temp = saved.poll();
        Result answer = new Result(temp[0], temp[1], minDist);
        map[answer.r][answer.c] = 0;
        return answer;
    }

    static class Result {
        int r, c, dist;
        public Result (int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
}