import java.util.*
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt(); val map = HashMap<String, Int>()
    repeat(n) {
        val st = StringTokenizer(readLine()); val name = st.nextToken(); val memo = st.nextToken()
        if(memo == "enter") map[name] = 1 else map[name] = 0
    }
    val m = map.filter { it.value == 1 }.keys.sortedDescending()
    val sb = StringBuilder()
    for(name in m) sb.appendLine(name)
    print(sb)
}