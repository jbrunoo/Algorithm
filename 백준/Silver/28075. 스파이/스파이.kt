import kotlin.math.abs
private lateinit var arr: IntArray
var n = 0
var m = 0
var cnt = 0

fun main()=java.io.StreamTokenizer(System.`in`.bufferedReader()).run{
    fun i():Int{nextToken();return nval.toInt()}
    n=i(); m=i()
    arr = IntArray(6){i()}
    calc()
    print(cnt)
}

fun calc(prevIdx : Int = -10, depth: Int = 0, sum: Int = 0) {
    if(depth == n) {
        if(sum >= m) cnt++
        return
    }
    for((i, v) in arr.withIndex()) {
        val nextValue = if(i == prevIdx || abs(prevIdx - i) == 3) v / 2 else v
        calc(i, depth+1, sum + nextValue)
    }
}