fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val sb = StringBuilder()
    var str = ""
    var blank = ""

    for (i in 1..n) {
        str += "@"; blank += " "
    }

    for (col in 1..5) {
        for (i in 1..n) {
            for (row in 1..5) {
                when (col) {
                    1, 5 -> {
                        if (row == 1 || row == 5) sb.append(str)
                        else sb.append(blank)
                    }
                    2, 4 -> {
                        if (row == 1 || row == 4) sb.append(str)
                        else if(row == 2 || row == 3) sb.append(blank)
                    }
                    3 -> if(row < 4) sb.append(str)
                    
                }
            }
            if(i != n || col != 5) sb.appendLine()
        }
    }

    print(sb)
}