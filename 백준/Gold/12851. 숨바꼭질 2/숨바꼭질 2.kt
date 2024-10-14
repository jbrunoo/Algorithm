import java.util.*

class Boj12851(private val k: Int) {
    private lateinit var visited: IntArray
    private var minSecond = Int.MAX_VALUE
    private var minWay = 0

    fun solve(n: Int) {
        visited = IntArray(100001) { 100001 }
        if(n == k){
            print("0\n1")
            return
        }
        teleport(n)
        print("$minSecond\n$minWay")
    }

    private fun teleport(n: Int) {
        val q = ArrayDeque<Seek>()
        q.offer(Seek(pos = n, second = 0))
        visited[n] = 1

        while (q.isNotEmpty()) {
            val (p, s) = q.poll()
            if (s > minSecond) break
            if (p == k) {
                minSecond = s
                minWay++
            }

            if (p > 0 && visited[p - 1] >= s + 1) {
                visited[p - 1] = s + 1
                q.offer(Seek(p - 1, s + 1))
            }
            if (p < k && visited[p + 1] >= s + 1) {
                visited[p + 1] = s + 1
                q.offer(Seek(p + 1, s + 1))
            }
            if (p * 2 <= 100000 && visited[p * 2] >= s + 1) {
                visited[p * 2] = s + 1
                q.offer(Seek(p * 2, s + 1))
            }
        }
    }

    data class Seek(val pos: Int = 0, val second: Int = 0, val way: Int = 0)
}

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt(); val k = st.nextToken().toInt()
    Boj12851(k).solve(n)
}