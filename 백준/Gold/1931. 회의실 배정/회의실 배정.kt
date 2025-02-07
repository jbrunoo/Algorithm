import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = ArrayList<Meet>()

    repeat(n) {
        val st = StringTokenizer(readLine())
        arr.add(Meet(st.nextToken().toInt(), st.nextToken().toInt()))
    }

    arr.sortBy { it.start }
    arr.sortBy { it.end }

    var ret = 0
    var initEnd = 0
    for((s, e) in arr) {
        if(initEnd <= s) {
            ret++
            initEnd = e
        }
    }
5
    print(ret)
}

data class Meet(
    val start: Int,
    val end: Int,
)