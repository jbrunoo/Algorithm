lateinit var arr: IntArray
lateinit var select: ArrayList<Int>
var same = 0

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i():Int{nextToken();return nval.toInt()};val sb=StringBuilder()
    select = ArrayList()
    repeat(i()) {
        arr = IntArray(i()) { i() }
        arr.sort()
        combi()
        sb.appendLine(same)
        same = 0
        select.clear()
    }
    print(sb)
}

fun combi(cnt: Int = 0, begin: Int = 0, depth: Int = 2) {
    if(cnt == depth) {
        val (a, b) = select
        val dist = arr[b]-arr[a]
        if(dist % 2 == 0) {
            if(arr.binarySearch(arr[a] + dist / 2) >= 0) same++
        }
        return
    }

    for(i in begin until arr.size) {
        select.add(i)
        combi(cnt + 1, i + 1, depth)
        select.removeLast()
    }
}