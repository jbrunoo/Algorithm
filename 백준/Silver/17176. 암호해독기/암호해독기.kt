import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val st = StringTokenizer(readLine())
    val map = HashMap<Char, Int>()
    repeat(n) {
        when (val c = st.nextToken().toInt()) {
            0 -> {
                if(map.containsKey(' ')) map[' '] = map[' ']!! + 1
                else map[' '] = 1
            }
            in 1..26 -> {
                if(map.containsKey('A' + c - 1)) map['A' + c - 1] = map['A' + c - 1]!! + 1
                else map['A' + c - 1] = 1
            }
            else -> {
                if(map.containsKey('a' + c - 27)) map['a' + c - 27] = map['a' + c - 27]!! + 1
                else map['a' + c - 27] = 1
            }
        }
    }
    val str = readLine()
    for(c in str) {
        if(map.containsKey(c) && map[c]!! > 0) map[c] = map[c]!! - 1
        else {
            print("n")
            return
        }
    }
    print("y")
}