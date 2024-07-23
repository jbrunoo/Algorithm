fun main() = with(System.`in`.bufferedReader()){
    val (n, m) = readLine().split(" ").map { it.toInt() }

    val A = Array(n) { BooleanArray(m) }
    val B = Array(n) { BooleanArray(m) }

    for (i in 0 until n) {
        val row = readLine().chunked(1).map { it.toInt() }
        for (j in 0 until m) {
            A[i][j] = row[j] == 1
        }
    }

    for (i in 0 until n) {
        val row = readLine().chunked(1).map { it.toInt() }
        for (j in 0 until m) {
            B[i][j] = row[j] == 1
        }
    }

    println(compare(A, B))
}

fun compare(A: Array<BooleanArray>, B: Array<BooleanArray>): Int {
    if(A.contentDeepEquals(B)) return 0
    if(A.size < 3 || A[0].size < 3) return -1

    var cnt = 0

    for(col in 0 until A.size - 2) {
        for(row in 0 until A[0].size - 2) {
            if(A[col][row] != B[col][row]) {
                reverse(A, col, row)
                cnt += 1
                if(A.contentDeepEquals(B)) return cnt
            }
        }
    }
    return -1
}


fun reverse(A: Array<BooleanArray>, col: Int, row: Int): Array<BooleanArray> {
    for(x in col..col + 2) {
        for(y in row..row + 2) {
            A[x][y] = !A[x][y]
        }
    }
    return A
}