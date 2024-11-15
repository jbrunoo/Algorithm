import kotlin.math.max

private lateinit var arr: Array<IntArray>
private lateinit var visited: Array<BooleanArray>
var n = 0
var m = 0

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt() }

    n = i(); m = i()
    arr = Array(n) { IntArray(m) { i() } }
    visited = Array(n) { BooleanArray(m) }

    var ret = 0; var size = 0

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (arr[i][j] == 1 && !visited[i][j]) {
                ret++
                size = max(size, dfs(i, j))
            }
        }
    }

    print("$ret\n$size")
}

val dx = listOf(-1, 1, 0, 0)
val dy = listOf(0, 0, -1, 1)

fun dfs(x: Int, y: Int): Int {
    visited[x][y] = true
    var cnt = 1

    for (i in 0..3) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || arr[nx][ny] == 0) continue
        cnt += dfs(nx, ny)
    }

    return cnt
}