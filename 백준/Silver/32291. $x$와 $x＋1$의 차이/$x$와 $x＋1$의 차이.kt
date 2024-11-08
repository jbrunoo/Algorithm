fun main() = (System.`in`.bufferedReader()).run {
    val x = readLine().toLong() + 1
    val sqrtX = kotlin.math.sqrt(x.toDouble()).toLong()
    val sb1 = StringBuilder("1")
    val sb2 = StringBuilder()

    for(i in 2..sqrtX) {
        if(x % i == 0L) {
            sb1.append(" ").append(i)
            if(i != x/i) sb2.insert(0, " ${x/i}")
        }
    }

    print(sb1); print(sb2)
}