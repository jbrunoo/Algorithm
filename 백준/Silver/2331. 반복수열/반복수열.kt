import java.util.*
import kotlin.math.pow

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val a = st.nextToken(); val p = st.nextToken().toInt()
    val arr = mutableListOf<Int>()
    arr.add(a.toInt())

    var prev = a
    while(true) {
        val num = calc(prev, p)
        if(num in arr) {
            print(arr.indexOf(num))
            break
        }
        arr.add(num)
        prev = num.toString()
    }
}

fun calc(n: String, p: Int): Int {
    var ret = 0.0
    for(c in n) ret += c.digitToInt().toDouble().pow(p)
    return ret.toInt()
}