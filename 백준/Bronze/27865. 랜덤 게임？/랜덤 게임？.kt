import kotlin.random.Random

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    var cnt = 0

    while(true) {
        if(cnt > 20000) println("틀렸습니다")

        val guess = Random.nextInt(1, n + 1)
        println("? $guess")

        val ans = readLine()

        if(ans == "Y") {
            println("! $guess")
            break
        }
        cnt++
    }
}