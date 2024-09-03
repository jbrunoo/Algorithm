import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val playTimes = 48 * 60
    var preScore: Int; var currentScore = 0
    var start1 = -1; var start2 = -1
    var ret1 = 0; var ret2 = 0

    repeat(n) {
        val st = StringTokenizer(readLine(), ": ")
        val team = st.nextToken().toInt()
        val ss = st.nextToken().toInt() * 60 + st.nextToken().toInt()

        preScore = currentScore
        if (team == 1) currentScore++ else currentScore--

        if(currentScore > 0) {
            if(start1 == -1) start1 = ss
            if(it == n - 1) ret1 += playTimes - start1
        } else if(currentScore < 0) {
            if(start2 == -1) start2 = ss
            if(it == n - 1) ret2 += playTimes - start2
        } else {
            if(preScore > 0) {
                ret1 += ss - start1; start1 = -1
            } else if(preScore < 0) {
                ret2 += ss - start2; start2 = -1
            }
        }
    }

    println("${(ret1 / 60).stringFill()}:${(ret1 % 60).stringFill() }")
    print("${(ret2 / 60).stringFill()}:${(ret2 % 60).stringFill()}")
}

fun Int.stringFill() = this.toString().padStart(2, '0')
