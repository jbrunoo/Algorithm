fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt() }

    val n = i(); val mp = i(); val mf = i(); val ms = i(); val mu = i()
    val table = Array(n) { IntArray(5) { i() } }

    var minCost = Int.MAX_VALUE
    val end = (1 shl n) - 1
    val tmpArray = IntArray(5)
    var minUnion = emptyList<Int>()

    for (i in 1..end) {
        val tmpUnion = mutableListOf<Int>()

        for (j in 0 until n) {
            if (i and (1 shl j) >= 1) {
                tmpUnion += j + 1
                tmpArray[0] += table[j][0]
                tmpArray[1] += table[j][1]
                tmpArray[2] += table[j][2]
                tmpArray[3] += table[j][3]
                tmpArray[4] += table[j][4]
            }
        }

        if (tmpArray[0] >= mp && tmpArray[1] >= mf && tmpArray[2] >= ms && tmpArray[3] >= mu) {
            if (tmpArray[4] < minCost) {
                minCost = tmpArray[4]
                minUnion = tmpUnion
            } else if (tmpArray[4] == minCost) {
                minUnion = compareUnion(minUnion, tmpUnion)
            }
        }
        tmpArray.fill(0)
    }

    if (minCost == Int.MAX_VALUE) print(-1) else print("$minCost\n${minUnion.joinToString(" ")}")
}

fun compareUnion(minUnion: List<Int>, tmpUnion: List<Int>): List<Int> {
    val len = kotlin.math.min(minUnion.size, tmpUnion.size)

    for (i in 0 until len) {
        if (minUnion[i] < tmpUnion[i]) return minUnion
        if (minUnion[i] > tmpUnion[i]) return tmpUnion
    }

    return if (len == minUnion.size) minUnion else tmpUnion
}