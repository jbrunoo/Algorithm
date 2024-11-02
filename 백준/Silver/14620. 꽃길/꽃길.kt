import kotlin.math.min

private lateinit var arr: Array<IntArray>
private lateinit var visited: Array<BooleanArray>
private lateinit var seed: MutableList<Pos>
var n = 0
var min = Int.MAX_VALUE

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt() }
    n = i()
    arr = Array(n) { IntArray(n) { i() } }
    visited = Array(n) { BooleanArray(n) }
    seed = mutableListOf()

    dfs(0,3)
    println(min)
}

fun dfs(cnt: Int, depth: Int) {
    if(cnt == depth) {
        min = min(min, getPrice())
        return
    }

    for(i in 1 until n - 1) {
        for(j in 1 until n - 1) {
            if(visited[i][j] || visited[i+1][j] || visited[i-1][j] || visited[i][j+1] || visited[i][j-1]) continue
            if(visited[i+1][j+1] || visited[i+1][j-1] || visited[i-1][j+1] || visited[i-1][j-1]) continue
            if(i != 1 && visited[i - 2][j]) continue
            if(i != n - 2 && visited[i + 2][j]) continue
            if(j != 1 && visited[i][j - 2]) continue
            if(j != n - 2 && visited[i][j + 2]) continue

            seed.add(Pos(i, j))
            visited[i][j] = true
            dfs(cnt + 1, depth)
            seed.removeLast()
            visited[i][j] = false
        }
    }
}

fun getPrice(): Int {
    var price = 0
    for(pos in seed) {
        val x = pos.x; val y = pos.y
        price += arr[x][y] + arr[x+1][y] + arr[x][y+1] + arr[x-1][y] + arr[x][y-1]
    }
    return price
}

data class Pos(val x: Int, val y: Int)