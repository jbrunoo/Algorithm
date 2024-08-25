import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    var k = st.nextToken().toInt()
    val arr = IntArray(n)

    for(i in n - 1 downTo 0) {
        arr[i] = readLine().toInt()
    }

    var ans = 0

    for(i in 0 until n) {
        if(k >= arr[i]) {
            ans += k / arr[i]
            k %= arr[i]
        }
    }

    print(ans)
}