import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val pq = PriorityQueue<Int>()
    val arr = ArrayList<Problem>(n)

    repeat(n) {
        val st = StringTokenizer(readLine())
        arr.add(Problem(st.nextToken().toInt(), st.nextToken().toInt()))
    }

    arr.sortBy { it.deadLine }

    repeat(n) {
        if(pq.isEmpty() || arr[it].deadLine > pq.size) {
            pq.offer(arr[it].ramen)
        } else {
            if(arr[it].ramen > pq.peek()) {
                pq.poll()
                pq.offer(arr[it].ramen)
            }
        }
    }

    var ret = 0
    while(pq.isNotEmpty()) {
        ret += pq.poll()
    }

    print(ret)
}

data class Problem(
    val deadLine: Int = 0,
    val ramen: Int = 0,
)