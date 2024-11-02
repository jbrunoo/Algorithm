private lateinit var visited: Array<BooleanArray>
private var n = 0
private var h = 0

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt() }
    n = i(); val m = i(); h = i()
    visited = Array(h + 1) { BooleanArray(n + 1) }

    repeat(m) {
        val a = i();
        val b = i()
        visited[a][b] = true
    }

    if (getResult(n)) print(0)
    else {
        for (i in 1..3) {
            if (combi(0, 1, i)) {
                print(i)
                return
            }
        }
        print(-1)
    }
}

fun combi(cnt: Int, beginRow: Int, depth: Int): Boolean {
    if (cnt == depth) return getResult(n)

    for (i in beginRow..h) {
        for (j in 1 until n) {
            if (i == 0) continue
            if (!visited[i][j] && !visited[i][j - 1] && !visited[i][j + 1]) {
                visited[i][j] = true
                if (combi(cnt + 1, i, depth)) return true
                visited[i][j] = false
            }
        }
    }
    return false
}

fun getResult(n: Int): Boolean {
    for (colIdx in 1..n) {
        var current = colIdx
        for (row in visited) {
            if (row[current - 1]) current--
            else if (row[current]) current++
        }
        if (current != colIdx) return false
    }
    return true
}
