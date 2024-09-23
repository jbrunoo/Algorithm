import java.io.StreamTokenizer
fun main()=StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken();return nval.toInt() }
    val n = i(); val arr = IntArray(n) {i()}
    var m = arr[n-1].toLong(); var s = 1L
    for(i in n-2 downTo 0) {
        s += arr[i] * m
        val tmp = m; m = s; s = tmp
    }
    print("${m-s} $m")
}