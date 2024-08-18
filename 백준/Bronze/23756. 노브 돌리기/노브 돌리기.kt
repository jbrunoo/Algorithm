fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    var a0 = readLine().toInt()
    var sum = 0

    repeat(n) {
        val a1 = readLine().toInt()
        val min = if(a0 <= a1) if(a1 - a0 <= 180) a1 - a0 else 360 - (a1 - a0)
        else if(a0 - a1 <= 180) a0 - a1 else 360 - (a0 - a1)

        sum += min
        a0 = a1
    }

    println(sum)
}