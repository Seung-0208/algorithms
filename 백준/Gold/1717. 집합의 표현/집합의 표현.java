import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main{
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n, m;
        n = Integer.parseInt(st.nextToken()); //집합의 개수
        arr = new int[n+1];
        for(int i=0; i<=n; i++) {
            arr[i] = i;
        }
        m = Integer.parseInt(st.nextToken()); //연산의 개수

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int cate = Integer.parseInt(st.nextToken()); //cate=0 -> 합집합, 1 -> 연산
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(cate == 0) union(a, b);
            else {
                arr[a] = find(a);
                arr[b] = find(b);
                String ans = arr[a] == arr[b] ? "YES" : "NO";
                bw.write(ans + "\n");
            }
        }

        bw.flush();
    }

    static int find(int idx) {
        if(idx == arr[idx]) return idx;
        return find(arr[idx]);
    }

    static void union(int a, int b) {
        arr[a] = find(a);
        arr[b] = find(b);
        int aPrent = arr[a];
        int bPrent = arr[b];
        if(arr[a] != arr[b]) {
            arr[aPrent] = bPrent;
        }
    }
}