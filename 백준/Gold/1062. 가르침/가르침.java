import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    private static int n, k, max;
    private static String[] sentences;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        max = 0;
        sentences = new String[n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            sentences[i] = str.substring(4, str.length() - 4);
        }

        if (k  < 5) {
            System.out.println(0);
            return;
        }

        // a1 c3 i9 n14 t20
        int bit = 0;
        bit |= (1 << 0);
        bit |= (1 << 2);
        bit |= (1 << 8);
        bit |= (1 << 13);
        bit |= (1 << 19);

        combination(0, 5, bit);
        
        System.out.println(max);
    }

    private static void combination(int start, int depth, int bit) {
        if (depth == k) {
            int temp = 0;
            for (String sentence : sentences) {
                boolean flag = true;
                for (int i = 0; i < sentence.length(); i++) {
                    if ((bit & (1 << sentence.charAt(i) - 'a')) == 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) temp++;
            }

            max = Math.max(max, temp);
            return;
        }

        for (int i = start; i < 26; i++) {
            if ((bit & (1 << i)) > 0) continue;
            combination(i + 1, depth + 1, bit | (1 << i));
        }
    }
}