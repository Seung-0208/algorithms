import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        //정보 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] mazes = new int[N][M]; //미로의 정보
        int[][] A = new int[N][M]; //현재까지 방문한 칸 개수 누적
        boolean[][] visited = new boolean[N][M]; //방문 여부
        //값 입력
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j=0; j<M; j++) {
                mazes[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }
        
        int cnt = 1; //방문한 칸 수
        Queue<int[]> q = new LinkedList<>(); //BFS 큐
        q.add(new int[] {0, 0}); //[0,0]부터 시작
        visited[0][0] = true;
        A[0][0] = 1;
        LinkedList<int[]> directions = new LinkedList<>();
        directions.add(new int[] {-1, 0}); //위로 이동
        directions.add(new int[] {1, 0}); //아래로 이동
        directions.add(new int[] {0, 1}); //오른쪽으로 이동
        directions.add(new int[] {0, -1}); //왼쪽으로 이동
        int x = 0, y= 0;
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            //인접한 노드 방문
            for(int[] dir : directions) {
                x = temp[0] + dir[0];
                y = temp[1] + dir[1];

                //미로를 넘어가는 것을 방지
                if(x>N-1) x = N-1;
                if(y>M-1) y = M-1;
                if(x<0) x = 0;
                if(y<0) y = 0;
                
                if(mazes[x][y] == 1 && !visited[x][y]) {
                    q.add(new int[] {x, y});
                    visited[x][y] = true;
                    A[x][y] = A[temp[0]][temp[1]] +1;

                    if(x==N-1 && y==M-1) {
                        System.out.println(A[x][y]);
                        return;
                    }
                }
            }
        }
    }
}
