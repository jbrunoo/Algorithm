import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        int[] original = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int key = Integer.parseInt(st.nextToken());

            original[i] = key;
            set.add(key);
        }

        StringBuilder sb = new StringBuilder();

        HashMap<Integer, Integer> map = new HashMap<>();

        int idx = 0;

        for (int v : set) {
            map.put(v, idx);
            idx++;
        }

        for (int i = 0; i < n; i++) {
            sb.append(map.get(original[i])).append(" ");
        }

        System.out.println(sb);
    }
}