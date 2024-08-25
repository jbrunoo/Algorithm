import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val st1 = StringTokenizer(readLine())

    val map = HashMap<Int, Int>()
    for(i in 1..n) { map[st1.nextToken().toInt()] = 1 }

    val m = readLine().toInt()
    val st2 = StringTokenizer(readLine())

    val sb = StringBuilder()

    for(i in 1..m) {
        val ans = map[st2.nextToken().toInt()] ?: 0
        sb.append(ans).append(" ")
    }

    print(sb)
}