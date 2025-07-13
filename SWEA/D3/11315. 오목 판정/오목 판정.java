import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.next());
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            int n = Integer.parseInt(sc.next());
            char[][] arr = new char[n][n];
            boolean flag = false;

            for(int i = 0; i < n; i++) {
                arr[i] = sc.next().toCharArray();
            }

            // row
            for(int i = 0; i < arr.length; i++) {
                int cnt = 0;
                for(int j = 0; j < arr[0].length; j++) {
                    if(arr[i][j] == 'o') cnt++;
                    else {
                        if(cnt >= 5) {
                            flag = true; break;
                        }
                        else cnt = 0;
                    }
                }
                if(cnt >= 5) flag = true;
                if(flag) break;
            }

            if(flag) {
                sb.append("YES").append("\n");
                continue;
            }

            // col
            for(int i = 0; i < arr.length; i++) {
                int cnt = 0;
                for(int j = 0; j < arr[0].length; j++) {
                    if(arr[j][i] == 'o') cnt++;
                    else {
                        if(cnt >= 5) {
                            flag = true; break;
                        }
                        else cnt = 0;
                    }
                }
                if(cnt >= 5) flag = true;
                if(flag) break;
            }

            if(flag) {
                sb.append("YES").append("\n");
                continue;
            }

            // 대각선
            for(int i = 0; i < arr.length; i++) {
                for(int j = 0; j < arr.length; j++) {
                    int temp = 0;

                    for(int k = 0; k < arr.length; k++) {
                        if(i + k >= arr.length || j + k >= arr.length) {
                            break;
                        }

                        if (arr[i + k][j + k] == 'o') temp++;
                        else {
                            if(temp >= 5) {
                                flag = true; break;
                            }
                            else temp = 0;
                        }
                    }
                    if(temp >= 5) flag = true;
                    if(flag) break;
                }
                if(flag) break;
            }

            if(flag) {
                sb.append("YES").append("\n");
                continue;
            }

            for(int i = 0; i < arr.length; i++) {
                for(int j = 0; j < arr.length; j++) {
                    int temp = 0;
                    for(int k = 0; k < arr.length; k++) {
                        if(i + k >= arr.length || j - k < 0) {
                            break;
                        }

                        if (arr[i + k][j - k] == 'o') temp++;
                        else {
                            if(temp >= 5) {
                                flag = true; break;
                            }
                            else temp = 0;
                        }
                    }
                    if(temp >= 5) flag = true;
                    if(flag) break;
                }
                if(flag) break;
            }

            if(flag) {
                sb.append("YES").append("\n");
                continue;
            }

            sb.append("NO").append("\n");

        }

        System.out.print(sb);
    }
}