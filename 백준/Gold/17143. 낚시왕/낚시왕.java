import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    private static int R, C, M, result;
    private static int[][] board, newBoard;
    private static ArrayList<Shark> sharks;
    private static ArrayList<Integer> toRemove;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[R][C];
        newBoard = new int[R][C];
        sharks = new ArrayList<>();
        toRemove = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            sharks.add(new Shark(r, c, s, d, z));
            board[r][c] = z;
        }

        result = 0;

        // 1초
        for (int i = 0; i < C; i++) {
            getShark(i);

            for (int row = 0; row < R; row++) {
                Arrays.fill(newBoard[row], 0);
            }

            for (Shark sh : sharks) {
                move(sh);
            }

            for (Integer z : toRemove) {
                removeShark(z);
            }

            toRemove.clear();

            for (int r = 0; r < R; r++) {
                board[r] = Arrays.copyOf(newBoard[r], C);
            }
        }

        System.out.println(result);
    }

    // 현재 c열에서 가장 가까운 상어
    private static void getShark(int c) {
        for (int i = 0; i < R; i++) {
            if (board[i][c] != 0) {
                result += board[i][c];
                removeShark(board[i][c]);
                board[i][c] = 0;
                break;
            }
        }
    }

    // d: 1 위 2 아래 3 오른쪽 4 왼쪽
    private final static int[] dr = { 0, -1, 1, 0, 0 };
    private final static int[] dc = { 0, 0, 0, 1, -1 };

    private static void move(Shark sh) {
        int d = sh.d;
        int r = sh.r;
        int c = sh.c;
        int s = sh.s;

        if (d == 1 || d == 2) s %= (R - 1) * 2;
        else s %= (C - 1) * 2;

        for (int i = 0; i < s; i++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
                if (d == 1) d = 2;
                else if (d == 2) d = 1;
                else if (d == 3) d = 4;
                else if (d == 4) d = 3;

                nr = r + dr[d];
                nc = c + dc[d];
            }

            r = nr;
            c = nc;
        }

        sh.r = r;
        sh.c = c;
        sh.d = d;
        if (newBoard[r][c] == 0) newBoard[r][c] = sh.z;
        else {
            toRemove.add(Math.min(newBoard[r][c], sh.z));
            newBoard[r][c] = Math.max(newBoard[r][c], sh.z);
        }

    }

    private static class Shark {
        int r, c, s, d, z;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    // 사이즈가 다 다르므로 고유한 값으로 삭제
    private static void removeShark(int z) {
        sharks.removeIf(sh -> sh.z == z);
    }
}