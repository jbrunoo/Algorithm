fun main() = with(System.`in`.bufferedReader()) {
    val li = ArrayList<Double>()
    while(true) {
        val n = readLine().toDouble()
        if(n == 999.0) break
        li.add(n)
    }
    val sb = StringBuilder()

    for((i, t) in li.withIndex()) {
        if(i == li.lastIndex) break
        sb.appendLine(String.format("%.2f", li[i + 1] - t))
    }

    print(sb)
}

//fun permutation(arr: IntArray):  {
//
//}
