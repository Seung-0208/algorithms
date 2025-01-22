import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();

        boolean[] isSquare = new boolean[(int)(max-min+1)];
        for(long i=2; i*i<=max; i++) {
            long square = i*i;
            long startIdx = min/square;
            if(min%square != 0) startIdx++;
            for(long j=startIdx; j*square <= max; j++) {
                isSquare[(int)(j*square-min)] = true;
            }
        }

        int cnt = 0;
        for(boolean isTrue : isSquare) {
            if(!isTrue) cnt++;
        }
        System.out.println(cnt);
    }
}