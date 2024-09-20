import java.io.StreamTokenizer
fun main()=StreamTokenizer(System.`in`.bufferedReader()).run{
    val sb=StringBuilder()
    fun i():Int{nextToken();return nval.toInt()}
    repeat(i()){sb.append(minOf(i(),i(),i())).append("\n")}
    print(sb)
}