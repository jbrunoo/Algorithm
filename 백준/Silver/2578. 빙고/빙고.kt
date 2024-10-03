private lateinit var arr: Array<IntArray>

fun main()=java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken();return nval.toInt() }
    arr = Array(5) { IntArray(5) { i() } }

    repeat(25) {
        val n = i()
        for (i in 0..4) {
            for (j in 0..4) {
                if (arr[i][j] == n) arr[i][j] = 0
            }
        }
        if (check()) {
            print(it + 1)
            return
        }
    }
}

fun check(): Boolean {
    var cnt = 0; var h = 0; var v = 0; var dl = 0; var dr = 0

    for(i in 0..4) {
        if(arr[i][i] == 0) dl++
        if(arr[i][4-i] == 0) dr++
        for(j in 0..4) {
            if(arr[i][j] == 0) h++
            if(arr[j][i] == 0) v++
        }
        if(h == 5) cnt++
        if(v == 5) cnt++

        h = 0; v = 0
    }

    if(dl == 5) cnt++
    if(dr == 5) cnt++

    return cnt >= 3
}