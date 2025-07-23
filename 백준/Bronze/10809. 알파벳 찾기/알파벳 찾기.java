import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] alphabet = new int[26];
        Arrays.fill(alphabet, -1);

        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';

            if (alphabet[idx] == -1) {
                alphabet[idx] = i;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int a : alphabet) {
            sb.append(a).append(" ");
        }

        System.out.println(sb);
    }
}