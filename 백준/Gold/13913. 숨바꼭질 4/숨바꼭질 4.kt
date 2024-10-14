import java.util.*

private lateinit var visited: IntArray
private lateinit var prev: IntArray
private lateinit var move: ArrayList<Int>

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt(); val k = st.nextToken().toInt()
    visited = IntArray(100001)
    prev = IntArray(100001)
    move = ArrayList()
    move.add(k)

    bfs(n, k)
}

fun bfs(n: Int, k: Int) {
    val q = ArrayDeque<Int>()
    q.offer(n)
    visited[n] = 1

    while(q.isNotEmpty()) {
        val p = q.poll()

        if(p == k) {
            val min = visited[p]-1
            again(0, min, k)
            println(min)
            val sb = StringBuilder()
            for(i in move.lastIndex downTo 0) {
                sb.append(move[i]).append(" ")
            }
            println(sb)
            break
        }

        for(next in listOf(p - 1, p + 1, p * 2)) {
            if(next in 0..100000) {
                if(visited[next] == 0 || visited[next] == visited[p] + 1) {
                    visited[next] = visited[p] + 1
                    prev[next] = p
                       q.offer(next)
                }
            }
        }
    }
}

fun again(cnt: Int, min: Int, idx: Int) {
    if(cnt == min) {
        return
    }
    move.add(prev[idx])
    again(cnt + 1, min, prev[idx])
}