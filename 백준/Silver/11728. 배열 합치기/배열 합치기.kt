fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {nextToken(); return nval.toInt() }
    val n =i();val m =i()
    val arr1 = IntArray(n) { i() }
    val arr2 = IntArray(m) { i() }

    val sb = StringBuilder()
    (arr1 + arr2).sorted().forEach {
        sb.append("$it ")
    }
    print(sb)
}
