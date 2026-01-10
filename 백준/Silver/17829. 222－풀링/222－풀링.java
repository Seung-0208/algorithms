import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = pooling(0, 0, N);
        sb.append(ans);

        System.out.println(sb);
        br.close();
    }

    static int pooling(int x, int y, int size) {
        if(size == 2) {
            int[] temp = {arr[x][y], arr[x+1][y], arr[x][y+1], arr[x+1][y+1]};
            Arrays.sort(temp);
            return temp[2];
        }

        int half = size/2;
        int a = pooling(x, y, half);
        int b = pooling(x+half, y, half);
        int c = pooling(x, y+half, half);
        int d = pooling(x+half, y+half, half);
        int[] temp = {a, b, c, d};
        Arrays.sort(temp);
        return temp[2];
    }
}