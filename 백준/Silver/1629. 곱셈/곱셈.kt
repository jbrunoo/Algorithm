import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val a = st.nextToken().toLong()
    val b = st.nextToken().toLong()
    val c = st.nextToken().toLong()

    println(pow(a, b, c))
}

fun pow(a: Long, b: Long, c: Long): Long {
    if(b == 1L) return a % c

    var ret = pow(a, b/2, c)
    ret = (ret * ret) % c
    if(b % 2 == 1L) ret = (ret * a) % c
    return ret
}