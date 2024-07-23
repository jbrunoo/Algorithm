import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var n = 0
var m = 0
lateinit var A: Array<BooleanArray>
lateinit var B: Array<BooleanArray>

fun main() {
    init()
    println(compare(A, B))
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(StringTokenizer(readLine())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
    }
    A = Array(n) { _ ->
        with(readLine()) {
            BooleanArray(m) {
                this[it] != '0'
            }
        }
    }
    B = Array(n) { _ ->
        with(readLine()) {
            BooleanArray(m) {
                this[it] != '0'
            }
        }
    }
    close()
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
            }
        }
    }
    return if(A.contentDeepEquals(B)) cnt else -1
}


fun reverse(A: Array<BooleanArray>, col: Int, row: Int): Array<BooleanArray> {
    for(x in col..col + 2) {
        for(y in row..row + 2) {
            A[x][y] = !A[x][y]
        }
    }
    return A
}