import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val pq = PriorityQueue<Int>()
    val arr = ArrayList<Request>(n)

    if(n == 0) {
        print(0)
        return@with
    }

    repeat(n) {
        val (p, d) = readLine().split(" ").map { it.toInt() }
        arr.add(Request(p, d))
    }

    arr.sortBy { it.day }

    repeat(n) {
        val (p, d) = arr[it]

        if(pq.size < d) {
            pq.offer(p)
        } else {
            if(pq.peek() < p) {
                pq.poll()
                pq.offer(p)
            }
        }
    }

    print(pq.sum())
}

data class Request(
    val pay: Int = 0,
    val day: Int = 0,
)