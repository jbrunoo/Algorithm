import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    st.nextToken(); val m = st.nextToken().toInt()
    val j = readLine().toInt()
    var left = 1; var right = m; var cnt = 0

    repeat(j) {
        val apple = readLine().toInt()

        if (apple > right) {
            val d = apple - right
            cnt += d; left += d; right = apple
        }
        else if (apple < left) {
            val d = left - apple
            cnt += d; left = apple; right -= d
        }
    }

    print(cnt)
}