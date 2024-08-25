import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    val sb = StringBuilder()

    repeat(t) {
        val st = StringTokenizer(readLine())
        val r = st.nextToken().toInt()
        val n = st.nextToken().toInt()

        sb.appendLine(combi(n, r))
    }

    print(sb)
}

fun combi(n: Int, r: Int): Int {
    if (r == 0 || n == r) return 1

    var result = 1
    for (i in 1..r) {
        result *= n - r + i
        result /= i
    }
    return result
}
