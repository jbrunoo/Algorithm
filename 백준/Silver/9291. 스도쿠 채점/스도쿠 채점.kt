import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    val n = readLine().toInt()

    repeat(n) { i ->
        val arr = Array(9) { IntArray(9) }
        repeat(9) { j ->
            val st = StringTokenizer(readLine())
            repeat(9) { k ->
                arr[j][k] = st.nextToken().toInt()
            }
        }
        if (i < n - 1) readLine()

        val ret = if (check(arr)) "CORRECT" else "INCORRECT "
        sb.append("Case ${i + 1}: $ret").append("\n")
    }

    print(sb)
}

fun check(arr: Array<IntArray>): Boolean {
    for (i in 0..8) {
        val tmp1 = BooleanArray(9)
        val tmp2 = BooleanArray(9)
        for(j in 0..8) {
            val idx1 = arr[i][j]-1
            val idx2 = arr[j][i]-1
            if (tmp1[idx1] || tmp2[idx2]) return false
            tmp1[idx1] = true; tmp2[idx2] = true
        }
    }

    for (i in 0..6 step (3)) {
        for (j in 0..6 step (3)) {
            val tmp = BooleanArray(9)
            for (c in 0..2) {
                for (r in 0..2) {
                    val idx = arr[i + c][j + r]-1
                    if (tmp[idx]) return false
                    tmp[idx] = true
                }
            }
        }
    }

    return true
}