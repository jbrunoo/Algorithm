private lateinit var arr: Array<IntArray>
private lateinit var visited: Array<BooleanArray>
val dx = listOf(0, 0, -1, 1)
val dy = listOf(-1, 1, 0, 0)
var r = 0
var c = 0
var k = 0
var ret = 0

fun main() = with(System.`in`.bufferedReader()) {
    val st = java.util.StringTokenizer(readLine())
    r = st.nextToken().toInt(); c = st.nextToken().toInt(); k = st.nextToken().toInt()
    arr = Array(r) { IntArray(c) }
    visited = Array(r) { BooleanArray(c) }

    repeat(r) {
        val row = readLine()
        for ((i, ch) in row.withIndex()) {
            if (ch == '.') arr[it][i] = 1
            else arr[it][i] = 0
        }
    }

    dfs(r-1, 0, 1)
    println(ret)
}

fun dfs(x: Int, y: Int, dist: Int) {

    visited[x][y] = true
    if(dist > k) return
    if(x == 0 && y == c - 1 && dist == k) {
        ret++
        return
    }

    for (i in 0..3) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx < 0 || ny < 0 || nx >= r || ny >= c || visited[nx][ny] || arr[nx][ny] == 0) continue

        visited[nx][ny] = true
        dfs(nx, ny, dist + 1)
        visited[nx][ny] = false
    }
}