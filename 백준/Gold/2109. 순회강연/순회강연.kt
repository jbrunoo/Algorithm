import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val pq = PriorityQueue<Request>(compareBy { it.pay })
    val arr = Array(n) { Request() }

    if(n == 0) {
        print(0)
        return@with
    }

    repeat(n) {
        val (p, d) = readLine().split(" ").map { it.toInt() }
        arr[it] = (Request(p, d))
    }

    arr.sortBy { it.day }

    repeat(n) {
        val (p, d) = arr[it]

        if(pq.size < d) {
            pq.offer(Request(p, d))
        } else {
            if(pq.peek().pay < p) {
                pq.poll()
                pq.offer(Request(p, d))
            }
        }
    }

    print(pq.sumOf { it.pay })
}

data class Request(
    val pay: Int = 0,
    val day: Int = 0,
)