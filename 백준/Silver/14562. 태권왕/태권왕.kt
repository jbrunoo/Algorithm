import java.io.StreamTokenizer
import java.util.*
lateinit var q: ArrayDeque<Score>
fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i():Int{nextToken();return nval.toInt()}
    val sb = StringBuilder()
    q = ArrayDeque()
    repeat(i()) {
        q.clear()
        q.offer(Score(i(), i(), 0))
        sb.append(bfs()).append("\n")
    }
    print(sb)
}
fun bfs(): Int {
    while (q.isNotEmpty()) {
        val (s, t, c) = q.poll()
        if (s == t) return c
        val x = s * 2;val y = t + 3;val z = s + 1
        if (x <= y) q.offer(Score(x, y, c + 1))
        if (z <= t) q.offer(Score(z, t, c + 1))
    }
    return 0
}
data class Score(val s:Int, val t:Int, val c:Int)