fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt() }
    val n = i(); val pq = java.util.PriorityQueue<Int>(); val arr = ArrayList<Request>(n)

    if(n == 0) {
        print(0); return
    }

    repeat(n) { arr.add(Request(i(), i())) }
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