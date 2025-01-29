import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String format = st.nextToken();
        String[] pluses = format.split("-");
        ArrayList<Integer> nums = new ArrayList<>();
        for(String s : pluses) {
            String[] tmpNums = s.split("\\+");
            int sum = 0;
            for(String sNum : tmpNums) {
                sum += Integer.valueOf(sNum);
            }
            nums.add(sum);
        }
        int ret = nums.get(0);
        for(int i=1; i<nums.size(); i++) {
            ret -= nums.get(i);
        }
        System.out.println(ret);
    }

}