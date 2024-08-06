import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val st = StringTokenizer(readLine())
    val arr = IntArray(n + 1)

    for(i in 1..n) {
        arr[i] = st.nextToken().toInt()
    }

    var max = 0
    val end = n + 1
    
    for((i, v) in arr.withIndex()) {
        val lemon = v - (end - i)
        if(max < lemon) max = lemon
    }

    println(max)
}
