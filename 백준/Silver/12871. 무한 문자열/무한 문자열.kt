fun main() = with(System.`in`.bufferedReader()) {
    val s = readLine(); val t = readLine()
    val sl = s.length; val tl = t.length
    val lcm = sl * tl / if(sl >= tl) gcd(sl, tl) else gcd(sl, tl)

    print(if(makeLcmStr(lcm, s) == makeLcmStr(lcm, t)) 1 else 0)
}

fun makeLcmStr(lcm: Int, s : String): String {
    var newStr = ""
    while(newStr.length != lcm) {
       newStr += s
    }
    return newStr
}

fun gcd(a : Int, b : Int): Int = if(b == 0) a else gcd(b, a % b)