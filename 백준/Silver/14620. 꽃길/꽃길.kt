import kotlin.math.min

private lateinit var arr: Array<IntArray>
private lateinit var visited: Array<BooleanArray>
var n = 0
var min = Int.MAX_VALUE

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt() }
    n = i()
    arr = Array(n) { IntArray(n) { i() } }
    visited = Array(n) { BooleanArray(n) }

    dfs(0, 0)
    println(min)
}

fun dfs(cnt: Int, price: Int) {
    if(cnt == 3) {
        min = min(min, price)
        return
    }

    for(i in 1 until n - 1) {
        for(j in 1 until n - 1) {
            if(check(i, j)) {
                dfs(cnt + 1, price + getPrice(i, j))
                notVisited(i, j)
            }
        }
    }
}

val dx = listOf(0, 0, -1, 1)
val dy = listOf(-1, 1, 0, 0)

fun check(x: Int, y: Int): Boolean {
    for(i in 0..3) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if(visited[nx][ny]) return false
    }
    return true
}

fun getPrice(x: Int, y:Int): Int {
    visited[x][y] = true
    var price = arr[x][y]
    for(i in 0..3) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        visited[nx][ny] = true
        price += arr[nx][ny]
    }

    return price
}

fun notVisited(x: Int, y: Int) {
    visited[x][y] = false
    for(i in 0..3) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        visited[nx][ny] = false
    }
}