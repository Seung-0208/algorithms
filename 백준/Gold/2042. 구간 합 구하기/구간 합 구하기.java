
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //수의 개수
        int M = Integer.parseInt(st.nextToken()); //수 변경 횟수
        int K = Integer.parseInt(st.nextToken()); //구간의 합 횟수

        int temp = 1;
        int k = 0;
        while(temp < N) {
            temp *= 2;
            k++;
        }

        long[] tree = new long[temp*2];
        for(int i=0; i<N; i++) {
            tree[temp+i] = Long.parseLong(br.readLine());
        }


        for(int i=temp-1; i>=1; i--) {
            tree[i] = tree[i*2]+tree[i*2+1];
        }


        for(int i=0; i<M+K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a == 1) { //수를 변경
                long c = Long.parseLong(st.nextToken());
                changeValue(tree, b+temp-1, c);
            } else { //실제 계산
                int c = Integer.parseInt(st.nextToken());
                long t = calculate(b+temp-1, c+temp-1, tree);
                sb.append(t).append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }

    static void changeValue(long[] tree, int index, long newNum) {
        //index 는 트리 기준 index
        tree[index] = newNum;
        while(index > 0 && index/2 >0) {
            index = index/2;
            tree[index] = tree[index*2]+tree[index*2+1];
        }
    }

    static long calculate(int s, int e, long[] tree) {
        //s, e 는 트리 기준 인덱스
        long sum = 0;
        while(s<=e) {
            if(s%2==1) {
                sum += tree[s];
            }
            if(e%2==0) {
                sum += tree[e];
            }
            s = (s+1)/2;
            e = (e-1)/2;
        }
        return sum;
    }
}