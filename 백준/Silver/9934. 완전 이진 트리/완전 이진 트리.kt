import kotlin.math.pow

private lateinit var arr: IntArray
private lateinit var ret: Array<MutableList<Int>>

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {nextToken(); return nval.toInt() }
    val k = i()
    val n = 2.toDouble().pow(k).toInt() - 1
    arr = IntArray(n) { i() }
    ret = Array(k) { mutableListOf() }
    reLevel(0, arr.size - 1, 0)

    val sb = StringBuilder()
    for(i in ret) {
        for(j in i) sb.append(j).append(" ")
        sb.append("\n")
    }

    print(sb)
}

fun reLevel(s: Int, e: Int, depth: Int) {
    if(s == e) {
        ret[depth].add(arr[s])
        return
    }
    val m = (s + e) / 2

    ret[depth].add(arr[m])
    reLevel(s, m-1, depth + 1)
    reLevel(m+1, e, depth + 1)
}
