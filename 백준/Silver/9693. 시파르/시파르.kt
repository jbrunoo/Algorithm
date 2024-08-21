fun main() = with(System.`in`.bufferedReader()) {
    var idx = 0

    while (true) {
        idx++
        var n = readLine().toInt()
        if (n == 0) break

        var cnt = 0
        while (n >= 5) {
            cnt += n / 5
            n /= 5
        }

        println("Case #$idx: $cnt")
    }
}