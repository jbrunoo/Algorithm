import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder(); val st = StringTokenizer(readLine())
    val h = st.nextToken().toInt(); val w = st.nextToken().toInt()
    val arr = Array(h) { IntArray(w) }

    repeat(h) {
        val row = readLine()
        for((i, r) in row.withIndex()) if(r == '.') arr[it][i] = -1
    }

    for(i in 0 until h) {
        for(j in 0 until w) {
            if(j == 0 || arr[i][j] == 0) {
                sb.append(arr[i][j]).append(" ")
                continue
            }
            if(arr[i][j - 1] >= 0){
                arr[i][j] = arr[i][j - 1] + 1
                sb.append(arr[i][j]).append(" ")
            } else sb.append(arr[i][j]).append(" ")

        }
        sb.appendLine()
    }

    print(sb)
}