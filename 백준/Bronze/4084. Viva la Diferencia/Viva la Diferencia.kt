import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()){
    while(true) {
        val list = readLine().split(" ").map { it.toInt() }
        if(list == listOf(0,0,0,0)) break

        var (a, b, c, d) = list
        var cnt = 0
        while(a != b || b != c || c != d) {
            cnt++
            val temp = a
            a = abs(a - b)
            b = abs(b - c)
            c = abs(c - d)
            d = abs(d - temp)
        }
        println(cnt)
    }
}