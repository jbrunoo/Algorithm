import java.util.*

private lateinit var visited: Array<BooleanArray>
var second = 0

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt(); val k = st.nextToken().toInt()
    visited = Array(2) { BooleanArray(500001) }

    if(n == k) print(0) else bfs(n, k)
}

fun bfs(n: Int, k: Int) {
    val q = ArrayDeque<Pos>()
    q.offer(Pos(n, k))
    visited[second % 2][n] = true

    while (q.isNotEmpty()) {
        second++
        val qs = q.size
        for(i in 1..qs) {
            val (x, y) = q.poll()

            for (nx in listOf(x - 1, x + 1, x * 2)) {
                val ny = y + second
                if (nx !in 0..500000 || ny !in 0..500000) continue
                if(nx == ny || visited[second % 2][ny]) {
                    print(second)
                    return
                }
                if(!visited[second % 2][nx]) {
                    visited[second % 2][nx] = true
                    q.offer(Pos(nx, ny))
                }
            }
        }
    }
    print(-1)
}

data class Pos(val np: Int, val kp: Int)