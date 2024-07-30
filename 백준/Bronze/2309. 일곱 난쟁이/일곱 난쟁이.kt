fun main() = with(System.`in`.bufferedReader()) {
    val heights = MutableList(9){ readLine().toInt() }
    val sum = heights.sum()
    var fin = false

    for(i in heights) {
        for(j in heights - i) {
            if (sum - i - j == 100) {
                fin = true
                heights.remove(i)
                heights.remove(j)
                break
            }
        }
        if(fin) break
    }

    for(h in heights.sorted()) {
        println(h)
    }

}