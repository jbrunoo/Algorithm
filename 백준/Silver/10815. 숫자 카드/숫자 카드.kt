import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val st1 = StringTokenizer(readLine())

    val set = HashSet<Int>()
    for(i in 1..n) { set.add(st1.nextToken().toInt()) }

    val m = readLine().toInt()
    val st2 = StringTokenizer(readLine())

    val sb = StringBuilder()

    for(i in 1..m) {
        val ans = set.contains(st2.nextToken().toInt())
        sb.append(if(ans) 1 else 0).append(" ")
    }

    print(sb)
}