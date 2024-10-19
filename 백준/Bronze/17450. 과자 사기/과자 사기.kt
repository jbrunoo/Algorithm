import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val arr = DoubleArray(3)
    repeat(3) {
        val st = StringTokenizer(readLine())
        val price = st.nextToken().toInt(); val weight = st.nextToken().toInt()
        val money = if(10 * price >= 5000) 10 * price - 500 else 10 * price
        val best = 10.0 * weight / money
        arr[it] = best
    }

    val max = arr.max()
    for((i, v) in arr.withIndex()) {
        if(v == max) {
            print(when(i) {
                0 -> 'S'
                1 -> 'N'
                else -> 'U'
            })
            break
        }
    }
}