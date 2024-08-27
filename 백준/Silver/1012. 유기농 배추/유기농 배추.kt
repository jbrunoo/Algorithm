import java.util.*

val dy = intArrayOf(-1, 0, 1, 0)
val dx = intArrayOf(0, 1, 0, -1)

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    val sb = StringBuilder()

    repeat(t) {
        val st = StringTokenizer(readLine())
        val m = st.nextToken().toInt()
        val n = st.nextToken().toInt()
        val k = st.nextToken().toInt()

        val arr = Array(m) { IntArray(n) }
        val visited = Array(m) { BooleanArray(n) }

        repeat(k) {
            val st2 = StringTokenizer(readLine())
            val x = st2.nextToken().toInt()
            val y = st2.nextToken().toInt()
            arr[x][y] = 1
        }

        var cnt = 0

        for(i in 0 until m) {
            for(j in 0 until n) {
                if(arr[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j, arr, visited)
                    cnt++
                }
            }
        }

        sb.appendLine(cnt)
    }

    print(sb)
}

fun dfs(x: Int, y: Int, arr: Array<IntArray>, visited: Array<BooleanArray>) {
    visited[x][y] = true

    for(i in 0..3) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if(ny < 0 || nx < 0 || nx >= arr.size || ny >= arr[0].size) continue
        if(arr[nx][ny] == 1 && !visited[nx][ny]) {
            visited[nx][ny] = true
            dfs(nx, ny, arr, visited)
        }
    }

}