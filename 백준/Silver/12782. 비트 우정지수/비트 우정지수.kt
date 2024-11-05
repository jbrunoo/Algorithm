import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val sb = StringBuilder()

    repeat(n) {
        val st = StringTokenizer(readLine())
        val a = st.nextToken(); val b = st.nextToken()
        var diff = 0; var oneCnt = 0

        for(i in a.indices) {
            if(a[i] != b[i]) {
                if(a[i] == '1') oneCnt++
                diff++
            }
        }

        sb.append(kotlin.math.max(oneCnt, diff - oneCnt)).append("\n")
    }

    print(sb)
}
