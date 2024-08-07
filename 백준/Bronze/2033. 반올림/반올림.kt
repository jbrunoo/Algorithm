import kotlin.math.pow

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine()
    var result = n.toInt()

    if(result <= 10) {
        println(n)
        return
    }

    for(i in 2..n.length) {
        val p = 10.0.pow(i - 1).toInt()
        val v = (result % p) / (p / 10)
        
        result = if(v >= 5) (result / p + 1) * p
        else (result / p) * p
    }

    println(result)
}