import java.util.*

val dx = intArrayOf(0, 1, 0, -1)
val dy = intArrayOf(-1, 0, 1, 0)
data class Node(val x: Int, val y: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    val arr = Array(n) { IntArray(m) }
    val visited = Array(n) { IntArray(m) }

    repeat(n) {
        val str = readLine()
        for(i in 0 until m) {
            arr[it][i] = str[i] - '0'
        }
    }

    bfs(0, 0, arr, visited)
    print(visited[n-1][m-1])
}

fun bfs(a: Int, b: Int, arr: Array<IntArray>, visited: Array<IntArray>) {
    val queue = LinkedList<Node>()
    visited[a][b] = 1
    queue.add(Node(a,b))

    while(queue.isNotEmpty()) {
        val (x, y) = queue.poll()
        for (i in 0..3) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if(nx < 0 || ny < 0 || nx >= arr.size || ny >= arr[0].size) continue
            if(arr[nx][ny] == 1 && visited[nx][ny] == 0) {
                queue.offer(Node(nx, ny))
                visited[nx][ny] = visited[x][y] + 1
            }
        }
    }
}