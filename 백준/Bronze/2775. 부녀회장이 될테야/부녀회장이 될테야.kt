fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    val arr = Array(15) { IntArray(15) }

    for(i in 0..14) {
        for(j in 1..14) {
            if(i == 0) arr[i][j] = j
            else {
                var tmp = 0
                for(k in 1..j) {
                    tmp += arr[i-1][k]
                }
                arr[i][j] = tmp
            }
        }
    }

    repeat(t) {
        val k = readLine().toInt()
        val n = readLine().toInt()

        println(arr[k][n])
    }
}

