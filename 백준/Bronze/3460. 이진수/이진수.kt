fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt(); val sb = StringBuilder()

    repeat(t) {
        var bi = 524288; var cnt = 19
        var n = readLine().toInt(); val arr = IntArray(20) { -1 }

        while(n != 0) {
            if(n >= bi) { arr[cnt] = cnt; n %= bi }
            bi /= 2; cnt--
        }

        for(i in arr) if(i != -1) sb.append("$i ")
        sb.appendLine()
    }
    
    print(sb)
}