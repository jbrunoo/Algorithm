import java.util.*

private lateinit var arr: Array<CharArray>
private lateinit var visited: Array<BooleanArray>
private lateinit var prev: MutableList<Char>
private var r = 0
private var c = 0
var max = 1

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    r = st.nextToken().toInt(); c = st.nextToken().toInt()
    arr = Array(r) { CharArray(c) }
    visited = Array(r) { BooleanArray(c) }
    prev = mutableListOf()

    repeat(r) {
        val row = readLine()
        for ((i, v) in row.withIndex()) arr[it][i] = v
    }

    visited[0][0] = true
    prev += arr[0][0]
    move(0, 0)
    println(max)

}

val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

fun move(x: Int, y: Int) {
    for (i in 0..3) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx < 0 || nx >= r || ny < 0 || ny >= c || visited[nx][ny]) continue
        if (arr[nx][ny] in prev) continue
        visited[nx][ny] = true
        prev.add(arr[nx][ny])
        max = kotlin.math.max(max, prev.size)
        move(nx, ny)
        prev.removeLast()
        visited[nx][ny] = false
    }
    return
}