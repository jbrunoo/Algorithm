val nums = charArrayOf('0', '1', '2')
private var n = 0
private var cnt = 0

fun main()=with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    count()
    print(cnt)
}

fun count(depth: Int = 0, number: String = "") {
    if(depth == n) {
        if(number.toInt() % 3 == 0) cnt++
        return
    }
    for(i in 0..2) {
        if(depth == 0 && i == 0) continue
        count(depth + 1, number + nums[i])
    }
}