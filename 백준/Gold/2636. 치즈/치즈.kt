import java.io.StreamTokenizer

lateinit var arr : Array<IntArray>
lateinit var visited : Array<BooleanArray>
lateinit var leftCheese : MutableList<Cheese>
val dx = listOf(-1, 1, 0, 0)
val dy = listOf(0, 0, -1, 1)
var n = 0
var m = 0

fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {nextToken(); return nval.toInt()}
    n = i(); m = i(); arr = Array(n) { IntArray(m) }

    for(i in 0 until n) for(j in 0 until m) arr[i][j] = i()

    val (t, c) = solve()
    println(t)
    print(c)
}

fun solve(): Pair<Int, Int> {
    var time = 0

    while(true) {
        visited = Array(n) { BooleanArray(m) }
        leftCheese = mutableListOf()
        dfs(1, 0)
        for((x, y) in leftCheese) arr[x][y] = 0
        time++

        var flag = true
        for(i in 0 until n) for(j in 0 until m) if(arr[i][j] != 0) flag = false
        if(flag) break
    }

    return Pair(time, leftCheese.size)

}

fun dfs(x: Int, y: Int) {
    visited[x][y] = true
    if(arr[x][y] == 1) {
        leftCheese += Cheese(x, y)
        return
    }

    for(i in 0..3) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if(nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny]) continue
        dfs(nx, ny)
    }
}

data class Cheese(val x: Int, val y: Int)