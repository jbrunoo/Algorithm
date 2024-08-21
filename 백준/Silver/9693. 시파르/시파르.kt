fun main() = with(System.`in`.bufferedReader()) {
    var idx = 0
    while(true) {
        idx++
        val n = readLine().toInt()
        if(n == 0) break

        var cnt = 0
        for(i in 5..n step 5) {
            var tmp = i
            while(tmp % 5 == 0) {
                cnt++
                tmp /= 5
            }
        }
        println("Case #$idx: $cnt")
    }
}