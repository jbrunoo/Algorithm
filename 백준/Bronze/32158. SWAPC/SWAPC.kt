import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val s = readLine()
    val q = LinkedList<Pair<Int, Char>>()
    val arr = CharArray(n)

    for((i, c) in s.withIndex()) {
        if(c == 'P' || c == 'C') {
            if(q.isNotEmpty()) {
                if(q.peek().second != c) {
                    val (swapI, swapC) = q.poll()
                    arr[swapI] = c
                    arr[i] = swapC
                } else q.offer(Pair(i, c))
            } else q.offer(Pair(i, c))
        } else arr[i] = c
    }

    while(q.isNotEmpty()) {
        val (i, c) = q.poll()
        arr[i] = c
    }

    print(arr.joinToString(""))
}