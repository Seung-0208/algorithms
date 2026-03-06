import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static int[][] guide = {{1,-1,0,0}, {0,0,1,-1}};
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;
        int startR=0, startC=0;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9) {
                    startR = i;
                    startC = j;
                    map[i][j] = 0;
                }
            }
        }

        int size = 2;
        int eaten = 0;
        int time = 0;

        while(true) {
            Result next = calculatePriority(startR, startC, size);
            if(next == null) break;

            time += next.dist;
            startR = next.r;
            startC = next.c;
            map[startR][startC] = 0;
            eaten++;
            if(eaten==size) {
                size++;
                eaten = 0;
            }
        }
        System.out.println(time);
    }

    //현재 위치, 현재 크기
    static Result calculatePriority(int r, int c, int size) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {r, c});
        PriorityQueue<int[]> candidates = new PriorityQueue<>(
                (a, b) -> {
                    if(a[0] != b[0]) return a[0] - b[0];
                    return a[1] - b[1];
                }
        );
        int[][] distance = new int[N][N];
        for(int i=0; i<N; i++) Arrays.fill(distance[i], -1);
        distance[r][c] = 0;
        int minDist = Integer.MAX_VALUE;
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            if(minDist < distance[curr[0]][curr[1]]) {
                continue;
            }

            for(int i=0; i<4; i++) {
                int nr = curr[0]+guide[0][i];
                int nc = curr[1]+guide[1][i];
                if(!(nr>=0 && nr<N && nc>=0 && nc<N)) continue;
                if(distance[nr][nc] != -1) continue; //방문 체크
                if(map[nr][nc] > size) continue; //이동 조건 체크
                distance[nr][nc] = distance[curr[0]][curr[1]]+1;

                //먹을 수 있는 물고긱 체크
                if(map[nr][nc] != 0 && map[nr][nc] < size) {
                    if(distance[nr][nc] < minDist) {
                        minDist = distance[nr][nc];
                        candidates.clear();
                        candidates.add(new int[] {nr, nc});
                    } else if (distance[nr][nc] == minDist){
                        candidates.add(new int[] {nr, nc});
                    }
                }

                q.add(new int[] {nr, nc});
            }
        }
        if(candidates.isEmpty()) return null;

        int[] arc = candidates.poll();
        int ar = arc[0];
        int ac = arc[1];
        return new Result(ar, ac, minDist);
    }

    static class Result{
        int r, c, dist;
        public Result(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
}