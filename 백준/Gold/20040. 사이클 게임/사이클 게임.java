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
        n = Integer.parseInt(st.nextToken()); //점의 개수
        arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = i;
        m = Integer.parseInt(st.nextToken()); //차레의 수
        List<int[]> cases = new ArrayList<>();
        for(int i=1; i<=m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            cases.add(new int[]{a, b});
        }
        for(int i=1; i<=m; i++) {
            int a = cases.get(i-1)[0];
            arr[a] = find(a); //3
            int b = cases.get(i-1)[1];
            arr[b] = find(b); //3
            if(arr[a] == arr[b]) {
                bw.write(String.valueOf(i) + "\n");
                bw.flush();
                return;
            } else {
                union(a, b);
            }
        }
        bw.write(String.valueOf(0)+"\n");
        bw.flush();

    }

    static int find(int i) {
        if(i == arr[i]) return i;
        else return find(arr[i]);
    }

    static void union(int a, int b){
        arr[a] = find(a); //a의 대표노드
        arr[b] = find(b); //b의 대표노드
        if(arr[a] != arr[b]) {
            arr[arr[a]] = arr[b];
        }
    }
}