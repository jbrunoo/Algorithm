import java.util.* import kotlin.math.max

private lateinit var arr: Array<IntArray>
private lateinit var visited: Array<BooleanArray>
private lateinit var walls: MutableList<Pair<Int, Int>>
var n = 0
var m = 0
val dx = listOf(-1, 1, 0, 0)
val dy = listOf(0, 0, -1, 1)

fun main() = with(System.`in`.bufferedReader()) {
    val st1 = StringTokenizer(readLine())
    n = st1.nextToken().toInt(); m = st1.nextToken().toInt()
    arr = Array(n) { IntArray(m) }
    walls = mutableListOf()

    repeat(n) {
        val st2 = StringTokenizer(readLine())
        for (i in 0 until m) {
            val num = st2.nextToken().toInt()
            arr[it][i] = num
            if(num == 0) walls += Pair(it, i)
        }
    }

    print(makeWall())
}

fun makeWall(): Int {
    val size = walls.size
    var max = 0

    for(i in 0 until size) {
        for(j in i + 1 until size) {
            for(k in j + 1 until size) {
                arr[walls[i].first][walls[i].second] = 1
                arr[walls[j].first][walls[j].second] = 1
                arr[walls[k].first][walls[k].second] = 1
                max = max(max, findSafeZone())
                arr[walls[i].first][walls[i].second] = 0
                arr[walls[j].first][walls[j].second] = 0
                arr[walls[k].first][walls[k].second] = 0
            }
        }
    }

    return max
}

fun findSafeZone(): Int {
    visited = Array(n) { BooleanArray(m) }

    for (i in 0 until n) for (j in 0 until m)  if(arr[i][j] == 2) dfs(i, j)

    var safe = 0
    for(i in 0 until n) for(j in 0 until m) if(arr[i][j] == 0 && !visited[i][j]) safe++

    return safe
}

fun dfs(x: Int, y: Int) {
    visited[x][y] = true

    for (i in 0..3) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx < 0 || ny < 0 || nx >= arr.size || ny >= arr[0].size) continue
        if (arr[nx][ny] == 0 && !visited[nx][ny]) {
            visited[nx][ny] = true
            dfs(nx, ny)
        }
    }
}