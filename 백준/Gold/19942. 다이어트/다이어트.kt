private lateinit var mn: IntArray
private lateinit var mns: Array<IntArray>
private lateinit var combiResult: MutableList<Int>
var min = Int.MAX_VALUE
var ret = ""

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt() }

    val n = i()
    mn = IntArray(4) { i() }
    mns = Array(n) { IntArray(5) { i() } }

    for(i in 1..n) {
        combiResult = mutableListOf()
        combi(0, 0, i)
    }
    if(min == Int.MAX_VALUE) print(-1)
    else print("$min\n$ret")
}


fun combi(cnt: Int, begin: Int, depth: Int) {
    if(cnt == depth) {
        var mp = 0
        var mf = 0
        var ms = 0
        var mu = 0
        var cost = 0

        combiResult.forEach { idx ->
            mp += mns[idx][0]
            mf += mns[idx][1]
            ms += mns[idx][2]
            mu += mns[idx][3]
            cost += mns[idx][4]
        }

        if(mn[0] <= mp && mn[1] <= mf && mn[2] <= ms && mn[3] <= mu) {
            val res = combiResult.map { it + 1 }.joinToString(" ")
            if(cost < min || (cost == min && isOrder(res))) {
                min = cost
                ret = res
            }
        }

        return
    }

    for(i in begin until mns.size) {
        combiResult += i
        combi(cnt + 1, i + 1, depth)
        combiResult -= i
    }

    return
}

fun isOrder(combiResult: String): Boolean = ret > combiResult