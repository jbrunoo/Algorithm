fun main() = print(solve(readln()))
fun solve(str: String):Long {
    var prevChar = ' '
    var ret = 1L
    for(c in str) {
        if(prevChar == c) {
            if(c == 'c') ret *= 25
            else ret *= 9
        } else {
            if(c == 'c') ret *= 26
            else ret *= 10
        }
        ret %= 1000000009
        prevChar = c
    }
    return ret
}