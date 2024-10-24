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
        if(i < n-1) readLine()

        val ret = if(check(arr)) "CORRECT" else "INCORRECT "
        sb.append("Case ${i+1}: $ret").append("\n")
    }

    print(sb)
}

fun check(arr: Array<IntArray>): Boolean {
    for(row in arr) if (row.toSet().size != 9 || row.any { it !in 1..9 }) return false

    for(i in 0..8) {
        val tmp = IntArray(9)
        for(j in 0..8) tmp[j] = arr[j][i]
        if(tmp.toSet().size != 9) return false
    }

    val tmp = mutableListOf<Int>()
    for(i in 0..6 step(3)) {
        for(j in 0..6 step(3)) {
            for(c in 0..2) for(r in 0..2) tmp.add(arr[i+c][j+r])
            if(tmp.toSet().count() != 9) return false
            tmp.clear()
        }
    }

    return true
}