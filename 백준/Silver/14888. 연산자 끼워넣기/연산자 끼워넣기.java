import java.io.*;
import java.util.*;

public class Main {
    //hint : 연산자를 배치하는 모든 경우를 DFS로 만들기
    static int[] numbers;
    static int[] count = new int[6];
    static int[] index = {1, 3, 0, 5};
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        count['+'-'*'] = Integer.parseInt(st.nextToken());
        count['-'-'*'] = Integer.parseInt(st.nextToken());
        count[0] = Integer.parseInt(st.nextToken());
        count['/'-'*'] = Integer.parseInt(st.nextToken());


        DFS(0, numbers[0]);

        sb.append(max).append("\n");
        sb.append(min);
        System.out.println(sb);
        br.close();
    }

    static void DFS(int idx, int current) {
        if(idx==N-1) {
            min = Math.min(min, current);
            max = Math.max(max, current);
        }

        for(int i : index) {
            if(count[i] > 0) {
                count[i]--;
                DFS(idx+1, apply((char)(i+'*'), numbers[idx+1], current));
                count[i]++;
            }
        }
    }

    static int apply(Character operator, int newNum, int prevNum) {
        switch (operator) {
            case '+': return prevNum + newNum;
            case '-': return prevNum - newNum;
            case '*': return prevNum * newNum;
            default : return prevNum / newNum;
        }
    }
}