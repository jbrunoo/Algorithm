import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val m = readLine().toInt()
    val st = StringTokenizer(readLine())
    val arr = IntArray(n) { st.nextToken().toInt() }
    var result = 0

    for(i in 0 until arr.size - 1) {
        for(j in i + 1 until arr.size) {
            if(arr[i] + arr[j] == m) result++
        }
    }

    println(result)
}