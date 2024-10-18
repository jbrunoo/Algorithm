import java.util.*

private lateinit var arr: Array<IntArray>
private lateinit var visited: Array<BooleanArray>
private var n = 0
private var m = 0
private var flag = false

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    fun i() = st.nextToken().toInt()
    n = i();m = i()
    st = StringTokenizer(readLine())
    val x1 = i()-1; val y1 = i()-1;i();i()
    arr = Array(n) { IntArray(m) }

    repeat(n) {
        val row = readLine()
        for ((i, v) in row.withIndex()) {
            if (v == '#' || v == '*') arr[it][i] = 2
            else arr[it][i] = v.digitToInt()
        }
    }

    var jump = 0
    while(true) {
        jump++
        visited = Array(n) { BooleanArray(m) }
        dfs(x1, y1)
        if(flag) break
    }

    print(jump)
}

val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

fun dfs(x: Int, y: Int) {
    visited[x][y] = true

    for (i in 0..3) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny]) continue
        visited[nx][ny] = true
        when(arr[nx][ny]) {
            0 -> dfs(nx, ny)
            1 -> arr[nx][ny] = 0
            2 -> {
                flag = true
                return
            }
        }
    }

}