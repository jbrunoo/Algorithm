import java.util.*

private lateinit var arr: Array<IntArray>
private lateinit var visited: Array<IntArray>
val dx = intArrayOf(1, 0, -1 ,0)
val dy = intArrayOf(0, -1, 0 ,1)

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val m = st.nextToken().toInt()
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    arr = Array(n) { IntArray(m) { 1 } }
    visited = Array(n) { IntArray(m) }

    repeat(k) {
        val st2 = StringTokenizer(readLine())
        val a = st2.nextToken().toInt()
        val b = st2.nextToken().toInt()
        val c = st2.nextToken().toInt()
        val d = st2.nextToken().toInt()

        for(i in a until c) for(j in b until d) arr[i][j] = 0
    }

    var cnt = 0
    val sizes = mutableListOf<Int>()

    for(i in 0 until n)
        for(j in 0 until m)
            if(arr[i][j] == 1 && visited[i][j] == 0) {
                cnt++
                sizes.add(bfs(i, j))
            }

    val sb = StringBuilder()
    sizes.sort()
    for(s in sizes) sb.append(s).append(" ")

    println(cnt)
    print(sb)
}

fun bfs(a: Int, b: Int): Int {
    visited[a][b] = 1
    val q = LinkedList<Node>()
    q.offer(Node(a, b))
    var size = 0

    while(q.isNotEmpty()) {
        size++
        val (x, y) = q.poll()

        for (i in 0..3) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx < 0 || ny < 0 || nx >= arr.size || ny >= arr[0].size) continue
            if (arr[nx][ny] == 1 && visited[nx][ny] == 0) {
                q.offer(Node(nx, ny))
                visited[nx][ny] = visited[x][y] + 1
            }
        }
    }


    return size
}

data class Node(val x: Int, val y: Int)