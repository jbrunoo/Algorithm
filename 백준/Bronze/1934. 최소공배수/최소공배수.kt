import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val sb = StringBuilder()

    repeat(n) {
        val st = StringTokenizer(readLine())
        val a = st.nextToken().toInt(); val b = st.nextToken().toInt()

        val gcd = if(a > b) gcd(a, b) else gcd(b, a)
        sb.appendLine(a * b / gcd)
    }

    print(sb)
}

fun gcd(a: Int, b: Int): Int {
    return if(b == 0) a
    else gcd(b, a % b)
}