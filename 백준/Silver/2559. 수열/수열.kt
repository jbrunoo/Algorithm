import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val arr = IntArray(n)
    val temp = IntArray(n - k + 1)
    val st = StringTokenizer(readLine())

    repeat(n) {
        arr[it] = st.nextToken().toInt()
    }
    temp[0] = arr.take(k).sum()

    for(i in 1..n - k) {
        temp[i] = temp[i - 1] - arr[i - 1] + arr[i + k - 1]
    }

    print(temp.max())
}