import java.io.StreamTokenizer

fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken();return nval.toInt() }
    val sb = StringBuilder(); val n = i(); val q = i()
    val arr = IntArray(n + 3)
    repeat(n) { arr[it] = i() }
    for (i in 0..2) arr[n + i] = arr[i]

    var sum = 0L
    for(i in 0 until n) sum += arr[i] * arr[i+1] * arr[i+2] * arr[i+3]

    repeat(q) {
        val qn = i()-1;

        for(i in qn-3..qn) {
            sum -= if(i < 0) arr[n+i] * arr[n+i+1] * arr[n+i+2] * arr[n+i+3]
            else arr[i] * arr[i+1] * arr[i+2] * arr[i+3]
        }

        arr[qn] *= -1
        if (qn < 3) arr[n + qn] *= -1

        for(i in qn-3..qn) {
            sum += if(i < 0) arr[n+i] * arr[n+i+1] * arr[n+i+2] * arr[n+i+3]
            else arr[i] * arr[i+1] * arr[i+2] * arr[i+3]
        }

        sb.appendLine(sum)
    }
    print(sb)
}
