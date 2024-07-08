fun main() {
    val n = readln().toInt()
    val arr = Array(n) { readln() }
    var result = 0

    arr.forEach { str ->
        if(isSeqStr(str)) result++
    }

    println(result)
}

fun isSeqStr(str: String): Boolean {
    val li = mutableListOf<Char>()
    str.forEach {
       if(it !in li) li += it
       else if(li.last() != it) return false
    }
    return true
}