import java.io.StreamTokenizer
import kotlin.math.min
fun main()=StreamTokenizer(System.`in`.bufferedReader()).run{
    fun i():Int{nextToken();return nval.toInt()}
    val sb=StringBuilder()
    repeat(i()){
        val a=i();val b=i();val c=i()
        sb.appendLine(min(min(a,b),min(b,c)))
    }
    print(sb)
}