// ascii
// char/int -> ascii

fun main() {
    println(aToI('A'))
    println(iToA(97))
    println(aToI('4'))
    println(iToA(48))
}

fun aToI(c: Char): Int {
    if(c.isLetterOrDigit()) return c.code // .toInt() deprecated
    else throw IllegalArgumentException("$c isn't letter or digit")
}

fun iToA(i: Int): Char {
    if(i in 1..127) return i.toChar()
    else throw IllegalArgumentException("$i isn't in 1..127")
}

// 숫자 char 그대로 int 변환 ('3' -> 3)
//// char - '0'
//// char.toString().toInt()
//// Character.getNumericValue(char)

// 숫자 int 그대로 char 변환 (3 -> '3')
//// int.digitToChar()
//// int.toString().toChar()
