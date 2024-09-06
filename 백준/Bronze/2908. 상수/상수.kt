import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    fun i(): Int = st.nextToken().reversed().toInt()
    val a = i(); val b = i()
    print(if(a > b) a else b)
}