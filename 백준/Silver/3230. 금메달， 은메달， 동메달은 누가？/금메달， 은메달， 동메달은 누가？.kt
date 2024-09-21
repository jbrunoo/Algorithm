import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine());
    val n = st.nextToken().toInt();
    val m = st.nextToken().toInt()
    val play1 = LinkedList<Int>()
    val play2 = LinkedList<Int>()

    repeat(n) {
        val i = readLine().toInt()
        play1.add(i-1, it)
    }

    play1.subList(0, m).reverse()
    repeat(m) {
        val i = readLine().toInt()
        play2.add(i-1, play1[it])
    }

    for(i in 0..2) println(play2[i]+1)
}
