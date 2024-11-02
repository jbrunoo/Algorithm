private lateinit var visited: Array<BooleanArray>
private var n = 0
private var h = 0
private var ret = 4
var flag = false

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt() }
    n = i(); val m = i(); h = i()
    visited = Array(h + 1) { BooleanArray(n + 1) }

    repeat(m) {
        val a = i(); val b = i()
        visited[a][b] = true
    }

    for (i in 0..3) {
        combi(0, 1, i)
        if (ret != 4) {
            print(ret)
            return
        }
    }
    print(-1)
}

fun combi(cnt: Int, beginRow: Int, depth: Int) {
    if(flag) return
    if (cnt == depth) {
        if(getResult(n)) {
            ret = cnt
            flag = true
        }
        return
    }

    for (i in beginRow..h) {
        var beginCol = 1
        for (j in beginCol until n) {
            if (i == 0) continue
            if (visited[i][j] || visited[i][j - 1] || visited[i][j + 1]) {
                beginCol += 2
                continue
            }
            visited[i][j] = true
            combi(cnt + 1, i, depth)
            visited[i][j] = false
        }
    }
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
