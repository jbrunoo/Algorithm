import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = ArrayList<Time>()


    repeat(n) {
        val st = StringTokenizer(readLine())
        arr.add(Time(st.nextToken().toInt(), st.nextToken().toInt()))
    }

    arr.sortBy { it.start }

    var ret = 0
    for((s, e) in arr) {
        ret += if(ret <= s) s - ret + e else e
    }

    print(ret)
}

data class Time(
    val start: Int,
    val end: Int,
)