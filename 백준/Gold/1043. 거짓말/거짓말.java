import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main{
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //사람의 수
        arr = new int[N+1];
        for(int i=1; i<=N; i++) arr[i] = i;

        int M = Integer.parseInt(st.nextToken()); //파티의 수

        //진실을 아는 사람
        st = new StringTokenizer(br.readLine());
        int truth = Integer.parseInt(st.nextToken());
        if(truth==0) {
            bw.write(String.valueOf(M));
            bw.flush();
            return;
        }
        //진실을 아는 사람끼리 연결
        List<Integer> theTruth = new ArrayList<>();
        int temp = Integer.parseInt(st.nextToken());
        theTruth.add(temp);
        for(int i=0; i<truth-1; i++) {
            int t =Integer.parseInt(st.nextToken());
            theTruth.add(t);
            arr[t] = temp;
        }

        //파티 정보
        ArrayList<Integer>[] party = new ArrayList[M];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            party[i] = new ArrayList<>();
            for(int j=0; j<cnt; j++) {
                party[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        //파티 정보에서 union 연산 수행
        for(ArrayList<Integer> p : party) {
            for(int i=0; i<p.size()-1; i++) {
                for(int j=i+1; j<p.size(); j++) {
                    arr[p.get(i)] = find(p.get(i));
                    arr[p.get(j)] = find(p.get(j));
                    union(p.get(i), p.get(j));
                }
            }
        }

        for(int i=1; i<=N; i++) arr[i] = find(i);

        //파티 개수 세어보기
        int ans = 0;
        for(ArrayList<Integer> p : party) {
            boolean isOk = true;
            for(Integer person : p) {
                if(arr[person] == arr[temp]) {
                    isOk = false;
                    break;
                }
            }
            if(isOk) ans++;
        }

        bw.write(String.valueOf(ans));
        bw.flush();

    }
    static int find(int node) {
        if(arr[node]==node) return node;
        return find(arr[node]);
    }

    static void union(int a, int b) {
        arr[a] = find(a);
        arr[b] = find(b);
        if(arr[a] != arr[b]) {
            arr[arr[a]] = arr[b];
        }
    }
}