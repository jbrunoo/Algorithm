import kotlin.math.abs

private lateinit var arr: Array<IntArray>
private lateinit var visited: Array<BooleanArray>
private lateinit var union: MutableList<Union>
private var n = 0
private var l = 0
private var r = 0
private var flag = false

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i():Int{nextToken();return nval.toInt()}
    n = i(); l = i(); r = i()
    arr = Array(n) { IntArray(n) }
    for(i in 0 until n) for(j in 0 until n) arr[i][j] = i()

    var day = 0

    while(true) {
        flag = false

        visited = Array(n) { BooleanArray(n) }

        for(i in 0 until n) {
            for(j in 0 until n) {
                if(!visited[i][j]) {
                    union = mutableListOf()
                    union += Union(i, j, arr[i][j])
                    dfs(i, j)
                    if(flag) movePop()
                }
            }
        }

        if(!flag) break
        day++
    }

    print(day)
}

val dx = listOf(-1, 1, 0, 0)
val dy = listOf(0, 0, -1, 1)

fun dfs(x: Int, y: Int) {
    visited[x][y] = true

    for(i in 0..3) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if(nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny]) continue
        if(abs(arr[x][y] - arr[nx][ny]) in l..r) {
            union += Union(nx, ny, arr[nx][ny])
            flag = true
            dfs(nx, ny)
        }
    }
}

fun movePop() {
    val n = union.count()
    val sum = union.sumOf { it.pop }
    val average = sum / n

    for ((r, c, _) in union) {
        arr[r][c] = average
    }
}

data class Union(val r: Int, val c: Int, val pop: Int)

