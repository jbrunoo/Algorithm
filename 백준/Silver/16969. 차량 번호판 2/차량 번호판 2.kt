fun main() = with(System.`in`.bufferedReader()) {
    print(solve(readLine()))
}

fun solve(str: String): Long {
    var prevChar = ' '
    var ret = 1L
    for (c in str) {
        ret *= if (prevChar == c) { if (c == 'c') 25 else 9 }
        else { if (c == 'c') 26 else 10 }
        ret %= 1000000009
        prevChar = c
    }
    return ret
}