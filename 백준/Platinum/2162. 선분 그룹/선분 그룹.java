
import java.io.*;
import java.util.*;

public class Main {
    static int[][] lineInfo;
    static int[] parent;

    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        lineInfo = new int[N+1][4];
        parent = new int[N+1];
        for(int i=1; i<=N; i++) parent[i] = -1;

        for(int i=1; i<=N; i++) {
            lineInfo[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for(int j=1; j<i; j++) {
                if(isMet(lineInfo[j], lineInfo[i])) {
                    union(j, i);
                }
            }
        }

        for(int i=1; i<=N; i++) {
            if(parent[i] > 0) parent[i] = find(parent[i]);
        }

        int cnt = 0;
        int max = -1;


        for(int i=1; i<=N; i++) {
            if(parent[i] < 0) {
                cnt++;
                if(parent[i]*(-1) > max) max = parent[i]*(-1);
            }
        }

        bw.write(cnt+"\n");
        bw.write(max+"\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static int find(int child) {
        if(parent[child] < 0) return child; //child 의 부모가 음수이면 child가 부모노드임
        return parent[child] = find(parent[child]);
    }

    static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        if(parentA == parentB) return;

        parent[parentA] += parent[parentB];
        parent[parentB] = parentA;
    }

    static int getCCW(int x1, int y1, int x2, int y2, int x3, int y3) {
        int ret = (x1*y2+x2*y3+x3*y1) - (x1*y3+x3*y2+x2*y1);
        return Integer.compare(ret, 0);
    }


    static boolean isMet(int[] line1, int[] line2) {
        int priorLine1 = getCCW(line1[0], line1[1], line1[2], line1[3], line2[0], line2[1]) * getCCW(line1[0], line1[1], line1[2], line1[3], line2[2], line2[3]);
        int priorLine2 = getCCW(line2[0], line2[1], line2[2], line2[3], line1[0], line1[1]) * getCCW(line2[0], line2[1], line2[2], line2[3], line1[2], line1[3]);


        if(priorLine1 == 0 && priorLine2 == 0) {
            return Math.min(line1[0], line1[2]) <= Math.max(line2[0], line2[2]) && Math.max(line1[0], line1[2]) >= Math.min(line2[0], line2[2]) &&
                    Math.min(line1[1], line1[3]) <= Math.max(line2[1], line2[3]) && Math.max(line1[1], line1[3]) >= Math.min(line2[1], line2[3]);
        }
        return priorLine1 <= 0 && priorLine2 <= 0;
    }
}