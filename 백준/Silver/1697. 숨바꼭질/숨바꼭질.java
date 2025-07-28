import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); int k = sc.nextInt();

        if (n == k) {
            System.out.println(0);
            return;
        }

        System.out.println(bfs(n, k));
    }

    static int bfs(int start, int end) {
        Queue<Pos> q = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        q.add(new Pos(start, 0));

        while(!q.isEmpty()) {
            Pos pos = q.poll();
            if (pos.x < 0 || pos.x > 100000 || visited[pos.x]) continue;
            if (pos.x == end) return pos.sec;

            visited[pos.x] = true;

            q.add(new Pos(pos.x + 1, pos.sec + 1));
            q.add(new Pos(pos.x - 1, pos.sec + 1));
            q.add(new Pos(pos.x * 2, pos.sec + 1));
        }

        return -1;
    }
}

class Pos {
    int x, sec;

    Pos(int x, int sec) {
        this.x = x;
        this.sec = sec;
    }
}