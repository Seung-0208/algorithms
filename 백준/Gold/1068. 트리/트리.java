
import java.io.*;
import java.util.*;

public class Main{
    static ArrayList<Integer>[] tree;
    static boolean[] isVisited;
    static int deletedNode;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //노드의 개수
        //초기화
        tree = new ArrayList[N];
        for(int i=0; i<N; i++) {
            tree[i] = new ArrayList<>();
        }
        isVisited = new boolean[N];
        //연결정보 입력
        st = new StringTokenizer(br.readLine());
        int root = -1;
        for(int i=0; i<N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if(tmp == -1) root = i;
            else {
                tree[tmp].add(i);
                tree[i].add(tmp);
            }
        }
        st = new StringTokenizer(br.readLine());
        deletedNode = Integer.parseInt(st.nextToken());
        if(root == deletedNode) bw.write("0\n");
        else{
            DFS(root);
            bw.write(ans+"\n");
        }

        bw.flush();
    }

    static void DFS(int node){
        isVisited[node] = true;
        boolean isLeafNode = true;
        for(int next : tree[node]) {
            if(!isVisited[next] && deletedNode != next) {
                isLeafNode = false;
                DFS(next);
            }
        }
        if(isLeafNode) ans++;
    }
}