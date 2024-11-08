import java.util.*

lateinit var q: ArrayDeque<Score>
lateinit var temp: ArrayDeque<Score>

fun main() = (System.`in`.bufferedReader()).run {
    val c = readLine().toInt()
    val sb = StringBuilder()
    q = ArrayDeque()
    temp = ArrayDeque()

    repeat(c) {
        val st = StringTokenizer(readLine())
        val s = st.nextToken().toInt();
        val t = st.nextToken().toInt()

        q.clear()
        temp.clear()
        q.offer(Score(s, t))

        var cnt = 0
        while(true) {
            if(bfs()) break
            q.addAll(temp)
            temp.clear()
            cnt++
        }

        sb.append(cnt).append("\n")
    }

    print(sb)
}

fun bfs(): Boolean {
    while (q.isNotEmpty()) {
        val (x, y) = q.poll()
        if (x == y) return true

        val nx1 = x * 2
        val ny1 = y + 3
        val nx2 = x + 1
        val ny2 = y

        if(nx1 <= ny1) temp.offer(Score(nx1, ny1))
        if(nx2 <= ny2) temp.offer(Score(nx2, ny2))
    }
    return false
}

data class Score(val s: Int, val t: Int)