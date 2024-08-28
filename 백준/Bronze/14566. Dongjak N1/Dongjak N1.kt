import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val st = StringTokenizer(readLine())
    val arr = IntArray(n) { st.nextToken().toInt() }

    arr.sort()

    var min = 32800000
    val map = HashMap<Int, Int>()
    map[min] = 1
    for(i in 0 until arr.size - 1) {
        val distance = arr[i + 1] - arr[i]
        if(min == distance) map[min] = map[min]!! + 1
        if(min > distance) {
            min = distance
            map[min] = 1
        }
    }

    print("$min ${map[min]}")
}