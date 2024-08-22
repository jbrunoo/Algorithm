import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val a = st.nextToken().toInt()
    val b = st.nextToken().toInt()
    
    val ans = if(a <= b) 2 * a - 1
    else 2 * b + 1

    print(ans)
}