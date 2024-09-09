import java.util.*
import kotlin.math.sqrt

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine()); fun i(): Int = st.nextToken().toInt()
    val w = i(); val h = i(); val x = i(); val y = i(); val p = i()
    var ret = 0
    
    repeat(p) {
        val st2 = StringTokenizer(readLine())
        val a = st2.nextToken().toInt(); val b = st2.nextToken().toInt()

        if(x <= a && a <= x + w) {
            if(y <= b && b <= y + h) ret += 1
        } else if(a < x) {
            val value = sqrt((x-a).toDouble() * (x-a) + (y + h / 2 - b) * (y + h / 2 - b))
            if(value <= h / 2) ret += 1
        } else {
            val value = sqrt((a - (x + w)).toDouble() * (a - (x + w)) + (y + h / 2 - b) * (y + h / 2 - b))
            if(value <= h / 2) ret += 1
        }

    }
    
    print(ret)
}