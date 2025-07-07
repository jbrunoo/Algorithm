import java.util.Scanner;

public class Main {
    static boolean[] lights;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String light = sc.next();
        int len = light.length();
        lights = new boolean[len + 1];

        for (int i = 1; i <= len; i++) {
            lights[i] = light.charAt(i - 1) == 'Y';
        }

        int cnt = 0;

        for (int i = 1; i <= len; i++) {
            if (lights[i]) {
                int tmp = i;
                while (tmp <= len) {
                    lights[tmp] = !lights[tmp];
                    tmp += i;
                }
                cnt++;
            }

            if (check()) {
                System.out.print(cnt);
                return;
            }
        }

        System.out.print(-1);
    }

    public static boolean check() {
        for (int i = 1; i < lights.length; i++) {
            if (lights[i]) return false;
        }
        return true;
    }
}