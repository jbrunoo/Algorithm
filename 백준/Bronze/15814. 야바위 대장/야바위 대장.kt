import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    var s = readLine()
    val n = readLine().toInt()

    repeat(n) {
        var ans = ""
        val st = StringTokenizer(readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()

        for((i, c) in s.withIndex()) {
            ans += if(i == a) s[b]
            else if(i == b) s[a]
            else c
        }

        s = ans
    }

    println(s)
}