import java.util.*

private lateinit var arr: Array<CharArray>
private lateinit var visited: BooleanArray
private var r = 0
private var c = 0
var max = 1

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    r = st.nextToken().toInt(); c = st.nextToken().toInt()
    arr = Array(r) { CharArray(c) }
    visited = BooleanArray(26)

    repeat(r) {
        val row = readLine()
        for ((i, v) in row.withIndex()) arr[it][i] = v
    }

    visited[arr[0][0] - 'A'] = true
    move()
    println(max)
}

val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

fun move(x: Int = 0, y: Int = 0, cnt: Int = 1) {
    max = kotlin.math.max(max, cnt)

    for (i in 0..3) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx < 0 || nx >= r || ny < 0 || ny >= c || visited[arr[nx][ny] - 'A']) continue
        visited[arr[nx][ny] - 'A'] = true
        move(nx, ny, cnt + 1)
        visited[arr[nx][ny] - 'A'] = false
    }
    return
}