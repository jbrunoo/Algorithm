import java.util.*

fun main() = with(System.`in`.bufferedReader()){
    val st = StringTokenizer(readLine())
    val a = st.nextToken().toBigInteger()
    val b = st.nextToken().toBigInteger()
    println(a*b)
}