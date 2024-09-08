fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val name = readLine()
    var ret = 0

    repeat(n) {
        val str = readLine()
        ret += check(name, str)
    }

    print(ret)
}

fun check(name: String, str: String): Int {
    for (i in str.indices) {
        for (j in i + 1 until str.length) {
            val distance = j - i
            var flag = true
            for (k in name.indices) {
                val pos = i + k * distance
                if (pos >= str.length || str[pos] != name[k]) {
                    flag = false
                    break
                }
            }
            if (flag) return 1
        }
    }
    return 0
}