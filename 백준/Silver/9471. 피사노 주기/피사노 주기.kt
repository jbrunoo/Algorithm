import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        val st = StringTokenizer(readLine())
        val N = st.nextToken().toInt()
        val m = st.nextToken().toInt()
        val n: Int = find(m)
        sb.append(N).append(" ").append(n).append("\n")
    }

    print(sb)
}

fun find(m: Int): Int {
    var a = 0; var b = 1; var cnt = 0
    // for (i in 0 until m * m) --> 123456 예제에서 오버플로우 발생으로 0 출력. 원인 찾는데 꽤 걸림.
    // 답이 int 범위를 벗어나지 않는다고 명시되어 있었고 이미 m * m 계산이 이루어진 걸 캐치하지 못했음.
    while(true) {
        val c = (a + b) % m
        a = b; b = c
        cnt++
        if (a == 0 && b == 1) return cnt
    }
    return 0
}