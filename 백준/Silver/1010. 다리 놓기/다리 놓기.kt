import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    val arr = Array(31) { IntArray(31) }

    for(i in 1..30) {
        for(j in i..30) {
            when (i) {
                j -> arr[i][j] = 1
                1 -> arr[i][j] = j
                else -> arr[i][j] += arr[i-1][j-1] + arr[i][j-1]
            }
        }
    }
    
    repeat(t) {
        val st = StringTokenizer(readLine())
        val n = st.nextToken().toInt()
        val m = st.nextToken().toInt()

        println(arr[n][m])
    }
}