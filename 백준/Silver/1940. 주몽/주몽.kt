import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val m = readLine().toInt()
    val st = StringTokenizer(readLine())
    val arr = IntArray(n) { st.nextToken().toInt() }
    var result = 0

    var l = 0
    var r = 1
    arr.sort()
    while(r < arr.size) {
        if(arr[l] + arr[r] == m) {
            result++
            l++
            r = l + 1
            continue
        }
        if(r == arr.size - 1) {
            l++
            r = l + 1
            continue
        }
        r++
    }

    println(result)
}