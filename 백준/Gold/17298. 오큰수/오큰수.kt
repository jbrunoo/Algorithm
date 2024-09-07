import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    val n = readLine().toInt()
    val st = StringTokenizer(readLine())
    fun i(): Int = st.nextToken().toInt()

    val stack = LinkedList<Int>()
    val arr = IntArray(1000000)
    val ret = IntArray(1000000) { -1 }

    for (i in 0 until n) {
        arr[i] = i()
        while (stack.isNotEmpty() && arr[stack.peek()] < arr[i]) {
            ret[stack.peek()] = arr[i]
            stack.pop()
        }
        stack.add(0, i)
    }

    for (i in 0 until n) sb.append(ret[i]).append(" ")
    
    print(sb)
}