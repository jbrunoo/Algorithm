import java.util.*
fun main() = with(System.`in`.bufferedReader()){
    val st = StringTokenizer(readLine())
    val a1 = st.nextToken().toInt()
    val a0 = st.nextToken().toInt()
    val c = readLine().toInt()
    val n = readLine().toInt()
    print(if(a1 * n + a0 <= c * n && a1 <= c) "1" else "0")
}