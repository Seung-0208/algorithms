import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main{
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //도시의 수
        arr = new int[N];
        for(int i=0; i<N; i++) arr[i]= i;

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); //여행 계획에 속한 도시의 수
        int[][] mapping = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                mapping[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //연결되어 있으면 루트 노드 업데이트 후 연결
        for(int i=0; i<N; i++) {
            for(int j=i+1; j<N; j++) {
                if(mapping[i][j]==1) {
                    union(i, j);
                }
            }
        }

        //여행 경로 받기
        st = new StringTokenizer(br.readLine());
        List<Integer> map = new ArrayList<>();
        for(int i=0; i<M; i++ ){
            int temp = Integer.parseInt(st.nextToken()) - 1;
            arr[temp] = find(temp);
            map.add(temp);
        }

        int root = arr[map.get(0)];
        int i;
        for(i=1; i<M; i++) {
            if(arr[map.get(i)] != root) {
                bw.write("NO\n");
                break;
            }
        }
        if(i==M) bw.write("YES\n");
        bw.flush();
    }
    static int find(int node) {
        if(arr[node] == node) return node;
        return find(arr[node]);
    }

    static void union(int a, int b) {
        arr[a] = find(a);
        arr[b] = find(b);
        arr[arr[a]] = arr[b];
    }
}