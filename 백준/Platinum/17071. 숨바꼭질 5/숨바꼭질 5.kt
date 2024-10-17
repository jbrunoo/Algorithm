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
    visited[second][n] = true

    while (q.isNotEmpty()) {
        second++
        ny += second

        for(i in 1..q.size) {
            val x = q.poll()

            for (nx in listOf(x - 1, x + 1, x * 2)) {
                if(ny > 500000) return -1
                if (nx !in 0..500000 || visited[second % 2][nx]) continue
                visited[second % 2][nx] = true

                if(visited[second % 2][ny]) return second
                q.offer(nx)
            }
        }
    }

    return -1
}