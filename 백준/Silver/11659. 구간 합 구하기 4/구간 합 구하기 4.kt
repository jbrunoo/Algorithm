import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    val (m, n) = readLine().split(" ").map { it.toInt() }
    val arr = IntArray(m)
    val st = StringTokenizer(readLine())
    for(i in 0 until m) {
        arr[i] += st.nextToken().toInt()
    }
    val memo = IntArray(m + 1)

    repeat(n) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        for(i in arr.indices) {
            if(memo[i + 1] == 0) memo[i + 1] = memo[i] + arr[i]
            if(memo[b] != 0) {
                sb.appendLine(memo[b] - memo[a - 1])
                break
            }
        }
    }
    println(sb)
}