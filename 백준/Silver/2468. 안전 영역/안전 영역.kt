import java.util.*

val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = Array(n) { IntArray(n) }
    val visited = Array(n) { BooleanArray(n) }

    for (i in 0 until n) {
        val st = StringTokenizer(readLine())
        for (j in 0 until n) {
            arr[i][j] = st.nextToken().toInt()
        }
    }

    var max = 0

    for(height in 1..100) {
        var cnt = 0

        for (i in 0 until n) {
            for (j in 0 until n) {
                if(arr[i][j] > 0 && !visited[i][j]) {
                    dfs(i, j, arr, visited)
                    cnt++
                }
            }
        }

        if(cnt == 0) break
        if(max < cnt) max = cnt

        for (i in 0 until n) {
            for (j in 0 until n) {
                arr[i][j]--
                visited[i][j] = false
            }
        }
    }

    print(max)
}

fun dfs(x: Int, y: Int, arr: Array<IntArray>, visited: Array<BooleanArray>) {
    visited[x][y] = true

    for (i in 0..3) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx < 0 || ny < 0 || nx >= arr.size || ny >= arr[0].size) continue
        if (arr[nx][ny] > 0 && !visited[nx][ny]) {
            visited[nx][ny] = true
            dfs(nx, ny, arr, visited)
        }
    }
}