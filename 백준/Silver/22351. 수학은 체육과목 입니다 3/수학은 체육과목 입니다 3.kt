fun main() = with(System.`in`.bufferedReader()) {
    val str = readLine()
    var i = 1
    var a: String
    var flag = true
    while(flag) {
        a = str.substring(0, i)
        find(a.toInt(), str)?.let {
            print("${it.first} ${it.second}")
            flag = false
        } ?: i++
    }
}

fun find(a: Int, str: String): Pair<Int, Int>? {
    var newStr = ""
    var next = a
    while(newStr.length < str.length) {
        newStr += next
        next++
    }
    return if(newStr == str) Pair(a, next-1) else null
}