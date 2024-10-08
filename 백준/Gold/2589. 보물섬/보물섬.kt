import java.util.*

private lateinit var arr: Array<CharArray>
private lateinit var visited: Array<IntArray>
private var n: Int = 0
private var m: Int = 0

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    n = st.nextToken().toInt(); m = st.nextToken().toInt()
    arr = Array(n) { CharArray(m) }

    repeat(n) {
        val row = readLine()
        for ((i, c) in row.withIndex()) {
            arr[it][i] = c
        }
    }

    var minDist = 0

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (arr[i][j] == 'L') {
                visited = Array(n) { IntArray(m) }
                minDist = kotlin.math.max(minDist, bfs(i, j))
            }
        }
    }

    print(minDist)
}

val dx = listOf(1, -1, 0, 0)
val dy = listOf(0, 0, 1, -1)

fun bfs(a: Int, b: Int): Int {
    val queue = ArrayDeque<Pos>()
    queue.offer(Pos(a, b))
    visited[a][b] = 1
    var dist = 0

    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()

        for (i in 0..3) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx < 0 || ny < 0 || nx >= n || ny >= m || arr[nx][ny] != 'L' || visited[nx][ny] != 0) continue
            visited[nx][ny] = visited[x][y] + 1
            dist = visited[nx][ny]
            queue.offer(Pos(nx, ny))
        }
    }

    return dist - 1
}

data class Pos(val x: Int, val y: Int)