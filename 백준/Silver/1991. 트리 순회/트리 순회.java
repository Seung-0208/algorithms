
import java.io.*;
import java.util.*;

public class Main {
    static String tmp = "";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 첫 줄: 숫자 7
        int n = Integer.parseInt(scanner.nextLine());
        int[][] tree = new int[2][n+1];

        // 다음 n줄: 문자열 3개씩 읽기
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine(); // 한 줄 전체 읽기
            char[] part = line.toCharArray();
            char parent = part[0];
            char left = part[2];
            char right = part[4];
            if(left-'A'+1 >= 0) tree[0][parent-'A'+1] = left-'A'+1;
            if(right-'A'+1 >= 0) tree[1][parent-'A'+1] = right-'A'+1;
        }

        preorder(tree, 1);
        System.out.println(tmp);

        tmp = "";
        inorder(tree, 1);
        System.out.println(tmp);

        tmp = "";
        postorder(tree, 1);
        System.out.println(tmp);


        scanner.close();
    }

    static void preorder(int[][] tree, int root) {
        if (root == 0) return;
        tmp += String.valueOf((char) (root + 'A' - 1));
        preorder(tree, tree[0][root]);
        preorder(tree, tree[1][root]);
    }

    static void inorder(int[][] tree, int root) {
        if (root == 0) return;
        inorder(tree, tree[0][root]);
        tmp += String.valueOf((char) (root + 'A' - 1));
        inorder(tree, tree[1][root]);
    }

    static void postorder(int[][] tree, int root) {
        if(root == 0) return;
        postorder(tree, tree[0][root]);
        postorder(tree, tree[1][root]);
        tmp += String.valueOf((char) (root+'A'-1));
    }


}