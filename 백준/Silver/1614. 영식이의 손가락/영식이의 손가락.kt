fun main() = with(System.`in`.bufferedReader()) {
    val f = readLine().toInt()
    val n = readLine().toInt()
    var sum = 0L

    repeat(n) {
        when (f) {
            1, 5 -> sum += 8
            2 -> sum += if(it % 2 == 0) 6 else 2
            4 -> sum += if(it % 2 == 0) 2 else 6
            3 -> sum += 4
        }
    }

    print(f + sum - 1)
}