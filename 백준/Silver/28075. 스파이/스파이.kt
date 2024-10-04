import kotlin.math.abs
private lateinit var arr: IntArray
private lateinit var visited: BooleanArray
private lateinit var ret: IntArray
var n = 0
var m = 0
var cnt = 0

fun main()=java.io.StreamTokenizer(System.`in`.bufferedReader()).run{
    fun i():Int{nextToken();return nval.toInt()}
    n=i(); m=i()
    arr = IntArray(6){i()}
    visited = BooleanArray(6)
    ret = IntArray(n)
    calc()
    print(cnt)
}

fun calc(prevIdx : Int = -10, depth: Int = 0) {
    if(depth == n) {
        if(m <= ret.sum()) cnt++
        return
    }
    for((i, v) in arr.withIndex()) {
        ret[depth] = if(i == prevIdx || abs(prevIdx - i) == 3) v / 2 else v
        visited[i] = true
        calc(i, depth+1)
        ret[depth] = 0
        visited[i] = false
    }
}