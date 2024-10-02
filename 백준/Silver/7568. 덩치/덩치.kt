import java.util.*
private lateinit var arr: Array<Pair<Int, Int>>

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    arr = Array(n) { Pair(0, 0) }

    repeat(n) {
        val st = StringTokenizer(readLine())
        val x = st.nextToken().toInt(); val y = st.nextToken().toInt()
        arr[it] = Pair(x, y)
    }

    val sb = StringBuilder()
    for(i in arr.indices) sb.append(compareAll(i)).append(" ")
    print(sb)
}

fun compareAll(idx: Int): Int {
    val x = arr[idx].first; val y = arr[idx].second
    var defeat = 1

    for((i, v) in arr.withIndex()) {
        if(i != idx) {
            val p = v.first; val q = v.second
            if(p > x && q > y) defeat++
        }
    }
    return defeat
}