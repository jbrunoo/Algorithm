fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken();return nval.toInt() }
    val n = i()
    var arrA = IntArray(n) { i() }
    var cnt = 0

    while(true) {
        val arrB = IntArray(n)
        cnt++
        for(i in arrA.indices) {
            var big = 0
            for(j in i+1 until arrA.size) {
                if(arrA[i] < arrA[j]) big++
            }
            arrB[i] = big
        }

        if(arrA.contentEquals(arrB)) break
        arrA = arrB
    }

    print(cnt)
}