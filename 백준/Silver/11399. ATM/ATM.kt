fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }.toIntArray().sorted()

    var sum = 0
    for(i in 0 until n) {
        for(j in 0..i) {
            sum += arr[j]
        }
    }

    println(sum)
}