import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer> tmp = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            tmp.add(n);
            rule(i);

            if(list.size() < tmp.size()) {
                list.clear();
                list.addAll(tmp);
            }

            tmp.clear();
        }

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");

        for(int i: list) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

    public static void rule(int i) {
        int idx = 1;
        tmp.add(i);

        while(true) {
            int nextValue = tmp.get(idx - 1) - tmp.get(idx);

            if(nextValue < 0) {
                break;
            }
            tmp.add(nextValue);

            idx++;
        }
    }
}