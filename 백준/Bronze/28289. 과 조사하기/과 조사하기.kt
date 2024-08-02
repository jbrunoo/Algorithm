import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val arr = IntArray(4)
    repeat(n) {
        val st = StringTokenizer(readLine())

        if(st.nextToken().toInt() == 1) arr[3]++
        else {
            when(st.nextToken().toInt()) {
                1, 2 -> arr[0]++
                3 -> arr[1]++
                4 -> arr[2]++
            }
        }
    }

    for(v in arr) {
        println(v)
    }
}