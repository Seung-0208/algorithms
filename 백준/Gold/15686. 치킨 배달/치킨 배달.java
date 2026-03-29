import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<int[]> homes = new ArrayList<>();
    static ArrayList<int[]> chickens = new ArrayList<>();
    static int M;
    static int min = Integer.MAX_VALUE;
    static ArrayList<int[]> selected = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int type = Integer.parseInt(st.nextToken());
                if(type == 2) chickens.add(new int[]{i,j});
                if(type == 1) homes.add(new int[]{i, j});
            }
        }

        if(chickens.size() == M) {
            min = calculate(chickens);
        } else {
            for(int i=0; i< chickens.size(); i++) {
                selected = new ArrayList<>();
                backtracking(i);
            }
        }

        sb.append(min);
        System.out.println(sb);
        br.close();
    }

    static void backtracking(int idx) {
        if(selected.size() == M) {
            min = Math.min(min, calculate(selected));
            return;
        }


        for(int i=idx; i<chickens.size(); i++) {
            selected.add(new int[] {chickens.get(i)[0], chickens.get(i)[1]});
            backtracking(i+1);
            selected.remove(selected.size()-1);
        }
    }

    static int calculate(ArrayList<int[]> selected) {
        int sum = 0;
        for(int[] home : homes) {
            int temp = Integer.MAX_VALUE;
            for(int[] chi : selected) {
                temp = Math.min(temp, Math.abs(home[0]-chi[0])+Math.abs(home[1]-chi[1]));
            }
            sum+=temp;
        }
        return sum;
    }
}