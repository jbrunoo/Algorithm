import java.io.StreamTokenizer

fun main() = StreamTokenizer((System.`in`.bufferedReader())).run {
    fun l(): Long { nextToken(); return nval.toLong() }
    val n = l().toInt(); val q = l()

    var idx = 0
    var min = Long.MAX_VALUE

    repeat(n) {
        val p = l(); val k = l(); val c = l()
        val t = if(q % k == 0L) (q / k) - 1 else q / k

        val tmp = p + t * (t + 1) / 2 * c
        if(min > tmp) {
            min = tmp
            idx = it + 1
        }
    }

    print("$idx $min")
}