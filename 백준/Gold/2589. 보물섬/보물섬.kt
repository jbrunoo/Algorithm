import java.util.*

private lateinit var arr: Array<IntArray>
private lateinit var visited: Array<IntArray>
private var n: Int = 0
private var m: Int = 0

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    n = st.nextToken().toInt(); m = st.nextToken().toInt()
    arr = Array(n) { IntArray(m) }

    repeat(n) {
        val row = readLine()
        for ((i, c) in row.withIndex()) {
            if (c == 'L') arr[it][i] = 1
            else arr[it][i] = 0
        }
    }

    var minDist = 0

    for(i in 0 until n) {
        for(j in 0 until m) {
            if(arr[i][j] == 1) {
                visited = Array(n) { IntArray(m) }
                val dist = bfs(i, j)
                minDist = kotlin.math.max(minDist, dist)
            }
        }
    }

    print(minDist)
}

val dx = listOf(1, -1, 0, 0)
val dy = listOf(0, 0, 1, -1)

fun bfs(a: Int, b: Int): Int {
    val queue = LinkedList<Pair<Int, Int>>()
    var dist = 0
    queue.offer(Pair(a, b))
    visited[a][b] = 1

    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()

        for (i in 0..3) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue
            if(arr[nx][ny] == 1 && visited[nx][ny] == 0) {
                visited[nx][ny] = visited[x][y] + 1
                dist = visited[nx][ny]
                queue.offer(Pair(nx, ny))
            }
        }
    }

    return dist - 1
}

