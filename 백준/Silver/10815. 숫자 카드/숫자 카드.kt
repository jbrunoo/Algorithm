import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val st1 = StringTokenizer(readLine())
    val map = hashMapOf<Int, Int>()
    while(st1.hasMoreTokens()) {
        map[st1.nextToken().toInt()] = 1
    }
    val m = readLine().toInt()
    val st2 = StringTokenizer(readLine())
    val arr2 = IntArray(m) { st2.nextToken().toInt() }

    val sb = StringBuilder()


    val last = arr2[m-1]

    for (i in 0 until m - 1) {
        val ans = if(map.containsKey(arr2[i])) 1 else 0
        sb.append("$ans ")
    }
    sb.append("${if(map.containsKey(arr2[m-1])) 1 else 0}")

    print(sb)
}