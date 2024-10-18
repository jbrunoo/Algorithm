import java.util.*

private lateinit var arr: Array<IntArray>
private lateinit var visited: Array<BooleanArray>
private var n = 0
private var m = 0
val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    fun i() = st.nextToken().toInt()
    n = i(); m = i()
    st = StringTokenizer(readLine())
    val x1 = i()-1; val y1 = i()-1; val x2 = i()-1; val y2 = i()-1
    arr = Array(n) { IntArray(m) }
    visited = Array(n) { BooleanArray(m) }

    repeat(n) {
        val row = readLine()
        for ((i, v) in row.withIndex()) {
            if (v == '#' || v == '*') arr[it][i] = 2
            else arr[it][i] = v.digitToInt()
        }
    }

    val q = ArrayDeque<Int>()
    q.offer(1000 * x1 + y1)

    var jump = 0
    while(arr[x2][y2] != 0) {
        jump++
        val tmp = ArrayDeque<Int>()

        while(q.isNotEmpty()) {
            val x = q.peek() / 1000; val y = q.poll() % 1000
            visited[x][y] = true

            for(i in 0..3) {
                val nx = x + dx[i]
                val ny = y + dy[i]

                if(nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny]) continue
                visited[nx][ny] = true
                when(arr[nx][ny]) {
                    0 -> q.offer(1000 * nx + ny)
                    1, 2 -> {
                        arr[nx][ny] = 0
                        tmp.offer(1000 * nx + ny)
                    }
                }
            }
        }
        q.addAll(tmp)
    }

    print(jump)
}