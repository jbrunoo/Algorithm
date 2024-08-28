import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = Array(n) { "" }
    val strike = IntArray(n)
    val ball = IntArray(n)

    for (j in 0 until n) {
        val st = StringTokenizer(readLine())
        arr[j] = st.nextToken()
        strike[j] = st.nextToken().toInt()
        ball[j] = st.nextToken().toInt()
    }

    print(count(n, arr, strike, ball))
}

fun count(n: Int, nums: Array<String>, strike: IntArray, ball: IntArray): Int {
    var cnt = 0
    for (i in 1..9) {
        for (j in 1..9) {
            for (k in 1..9) {
                if (i == j || j == k || k == i) continue

                var tmp = 0
                for (idx in 0 until n) {
                    val num = nums[idx]
                    val s = strike[idx]
                    val b = ball[idx]
                    var S = 0
                    var B = 0

                    if (i == num[0] - '0') S++
                    if (j == num[1] - '0') S++
                    if (k == num[2] - '0') S++

                    if (i == num[1] - '0' || i == num[2] - '0') B++
                    if (j == num[0] - '0' || j == num[2] - '0') B++
                    if (k == num[0] - '0' || k == num[1] - '0') B++

                    if (s == S && b == B) tmp++
                }
                
                if (tmp == n) cnt++
            }
        }
    }

    return cnt
}