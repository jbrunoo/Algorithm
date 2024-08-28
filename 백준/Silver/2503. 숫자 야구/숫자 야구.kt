import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = IntArray(1000)

    for (j in 1..n) {
        val st = StringTokenizer(readLine())
        val nums = st.nextToken()
        val s = st.nextToken().toInt()
        val b = st.nextToken().toInt()

        for (i in 1..9) {
            for(j in 1..9) {
                for (k in 1..9) {
                    if(i == j || j == k || k == i) continue
                    val ans = (i * 100 + j * 10 + k).toString()
                    val (S, B) = compare(ans, nums)
                    if(s == S && b == B) arr[ans.toInt()]++
                }
            }
        }
    }

    print(arr.count { it == n })
}

fun compare(ans: String, guess: String): Pair<Int, Int> {
    var s = 0
    var b = 0

    for (i in 0..2) {
        if (ans[i] == guess[i]) s++
        else if (ans[i] in guess) b++
    }

    return Pair(s, b)
}