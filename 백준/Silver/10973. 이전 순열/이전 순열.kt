import java.io.StreamTokenizer

fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {nextToken(); return nval.toInt() }

    val n = i()
    val arr = IntArray(n) { i() }.toMutableList()

    if(permutation(arr)) print(arr.joinToString(" ")) else print(-1)
}

fun permutation(arr: MutableList<Int>): Boolean {
    val n = arr.size
    var i = n - 2

    while (i >= 0 && arr[i] <= arr[i + 1]) { i-- }
    if (i < 0) return false

    var j = n - 1
    while (arr[j] >= arr[i]) { j-- }

    arr[i] = arr[j].also { arr[j] = arr[i] }
    arr.subList(i + 1, n).reverse()
    return true
}
