
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line = br.readLine();
        String[] token = line.split("-");

        ArrayList<Integer> items = new ArrayList<>();

        for(String l : token) {
            int sum = 0;
            for(String sNum : l.split("\\+")) {
                sum += Integer.parseInt(sNum);
            }
            items.add(sum);
        }

        int total = items.get(0);
        for(int i=1; i<items.size(); i++) total -= items.get(i);

        sb.append(total);

        System.out.println(sb);
        br.close();
    }

}