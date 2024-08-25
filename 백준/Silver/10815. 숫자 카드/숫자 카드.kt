import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val st1 = StringTokenizer(readLine())
    val map = HashMap<Int, Int>()
    for(i in 1..n) { map[st1.nextToken().toInt()] = 1 }
    val m = readLine().toInt()
    val st2 = StringTokenizer(readLine())
    val arr2 = IntArray(m) { st2.nextToken().toInt() }

    val sb = StringBuilder()

    for(i in arr2) {
        if(map[i] == 1) sb.append("1") else sb.append("0")
        if(i != arr2.last()) sb.append(" ")
    }

    print(sb)
}