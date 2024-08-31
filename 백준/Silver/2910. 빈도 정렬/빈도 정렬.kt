import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val st2 = StringTokenizer(readLine()); val map = mutableMapOf<Int, Int>()

    for(i in 1..n) {
        val num = st2.nextToken().toInt()
        if(!map.containsKey(num)) map[num] = 1
        else map[num] = map[num]!! + 1
    }

    val new = map.toList().sortedByDescending { it.second }
    val sb = StringBuilder()

    for((k, v) in new) for(i in 1..v) sb.append("$k ")
    print(sb)
}