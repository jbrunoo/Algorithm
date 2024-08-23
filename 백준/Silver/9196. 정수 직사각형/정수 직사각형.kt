import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    val li = mutableListOf<Pair<Int, Int>>()

    for(i in 1..149) {
        for(j in i + 1..150) {
            li.add(Pair(i, j))
        }
    }

    li.sortBy{ it.first }
    li.sortBy{ it.first * it.first + it.second * it.second }

    while(true) {
        val st = StringTokenizer(readLine())
        val h = st.nextToken().toInt()
        val w = st.nextToken().toInt()
        if(h == 0) break

        val ans = li.indexOf(Pair(h, w))
        sb.appendLine("${li[ans + 1].first} ${li[ans + 1].second}")
    }

    print(sb)
}