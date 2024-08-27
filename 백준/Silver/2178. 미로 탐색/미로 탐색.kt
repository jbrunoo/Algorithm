import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    val arr = Array(n) { IntArray(m) }
    val visited = Array(n) { IntArray(m) }

    repeat(n) {
        val str = readLine()
        for(i in 0 until m) {
            arr[it][i] = str[i].digitToInt()
        }
    }

    bfs(0, 0, arr, visited)
    print(visited[n-1][m-1])
}

fun bfs(a: Int, b: Int, arr: Array<IntArray>, visited: Array<IntArray>) {
    val queue = LinkedList<Pair<Int, Int>>()
    visited[a][b] = 1
    queue.add(Pair(a, b))

    val dx = intArrayOf(0, 1, 0, -1)
    val dy = intArrayOf(-1, 0, 1, 0)

    while(queue.isNotEmpty()) {
        val (x, y) = queue.pop()
        for (i in 0..3) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if(nx < 0 || ny < 0 || nx >= arr.size || ny >= arr[0].size) continue
            if(arr[nx][ny] == 1 && visited[nx][ny] == 0) {
                queue.add(Pair(nx, ny))
                visited[nx][ny] = visited[x][y] + 1
            }
        }
    }
}