import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //수열의 모든 수는 단 한번만 묶거나, 아니면 묶지 않아야한다
        //주어진 수는 음수일 수 있다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<Integer> ones = new ArrayList<Integer>();
        ArrayList<Integer> zeros = new ArrayList<Integer>();
        PriorityQueue<Integer> pos = new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<Integer> neg = new PriorityQueue<Integer>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int temp = Integer.parseInt(st.nextToken());
            if(temp == 0) zeros.add(temp);
            else if(temp == 1) ones.add(temp);
            else if(temp < 0) neg.add(temp);
            else pos.add(temp);
        }

        long ans = 0;
        while(pos.size() > 1) {
            int a = pos.poll(), b = pos.poll();
            ans += ((long) a *b);
        }
        if(pos.size()==1) ans += pos.poll();

        while(neg.size() > 1) {
            int a = neg.poll(), b = neg.poll();
            ans += ((long) a*b);
        }
        if(neg.size()==1 && zeros.isEmpty()) ans += neg.poll();
        
        for(int i=0; i<ones.size(); i++) {
            ans += 1;
        }

        System.out.println(ans);
    }//main
}
