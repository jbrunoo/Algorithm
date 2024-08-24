fun main() = with(System.`in`.bufferedReader()) {
    val R = readLine().toInt()
    val my = readLine()
    val N = readLine().toInt()
    val arr = Array(N) { "" }

    repeat(N) {
        arr[it] = readLine()
    }

    val map = mutableMapOf('S' to 0, 'R' to 0, 'P' to 0)
    var score = 0
    var maxScore = 0

    for (i in 0 until R) {
        for (s in arr) {
            score += getScore(my[i], s[i])
            map[s[i]] = map[s[i]]!! + 1
        }
        val scoreS = map['S']!! * 2 + map['R']!!
        val scoreR = map['R']!! * 2 + map['P']!!
        val scoreP = map['P']!! * 2 + map['S']!!
        maxScore += maxOf(scoreS, scoreR, scoreP)

        map['S'] = 0
        map['R'] = 0
        map['P'] = 0
    }
    print("$score\n$maxScore")
}

fun getScore(a: Char, b: Char): Int {
    return when(a) {
        'S' -> if(b == 'P') 2 else if(b == 'R') 0 else 1
        'R' -> if(b == 'S') 2 else if(b == 'P') 0 else 1
        'P' -> if(b == 'R') 2 else if(b == 'S') 0 else 1
        else -> 0
    }
}