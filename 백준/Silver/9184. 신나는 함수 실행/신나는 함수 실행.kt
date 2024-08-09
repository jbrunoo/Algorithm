import java.util.*

val wArr = Array(21) { Array(21) { IntArray(21) } }

fun main() = with(System.`in`.bufferedReader()) {
    wArr[0][0][0] = 1
    val sb = StringBuilder()

    while (true) {
        val s = readLine()
        if (s == "-1 -1 -1") break

        val st = StringTokenizer(s)
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val c = st.nextToken().toInt()

        val result = w(a, b, c)
        sb.appendLine("w($a, $b, $c) = $result")
    }
    println(sb)
}

fun w(a: Int, b: Int, c: Int): Int {
    if (a <= 0 || b <= 0 || c <= 0) return wArr[0][0][0]
    if (a > 20 || b > 20 || c > 20) return w(20, 20, 20)
    if (wArr[a][b][c] != 0) return wArr[a][b][c]

    if (a < b && b < c) wArr[a][b][c] =
        w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c)
    else wArr[a][b][c] =
        w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1)

    return wArr[a][b][c]
}