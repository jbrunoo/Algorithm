fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    var cnt = 1
    var num = 666

    while(true) {
        if(cnt == n) {
            print(num)
            break
        }
        num++
        var tmp = num
        while(tmp >= 666) {
            if(tmp % 1000 == 666) {
                cnt++
                break
            } else {
                tmp /= 10
            }
        }
    }
}