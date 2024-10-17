import java.util.*

private lateinit var visited: Array<BooleanArray>

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt(); val k = st.nextToken().toInt()
    visited = Array(2) { BooleanArray(500001) }

    print(bfs(n, k))
}

fun bfs(n: Int, k: Int): Int {
    if(n == k) return 0
    val q = ArrayDeque<Int>()
    q.offer(n)
    var ny = k
    var second = 0
    var s : Int
    visited[second][n] = true

    while (q.isNotEmpty()) {
        ny += ++second
        s = second % 2
        if(ny > 500000) return -1

        val qs = q.size
        for(i in 1..qs) {
            val x = q.poll()

            for (nx in intArrayOf(x - 1, x + 1, x * 2)) {
                if (nx < 0 || nx > 500000 || visited[s][nx]) continue
                visited[s][nx] = true
                q.offer(nx)
            }
        }
        if(visited[s][ny]) return second
    }

    return -1
}