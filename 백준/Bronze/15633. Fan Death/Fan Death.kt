import kotlin.math.sqrt

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    var sum = 0

    for(i in 1..sqrt(n.toFloat()).toInt()) {
        if(n % i == 0) {
            sum += i
            if(i * i == n) {
                continue
            } else {
                sum += n / i
            }
        }
    }

    println(sum * 5 - 24)
}