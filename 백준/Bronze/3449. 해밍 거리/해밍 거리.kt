fun main() = with(System.`in`.bufferedReader()){
    val t = readLine().toInt();val sb = StringBuilder()

    repeat(t) {
        val a = readLine();val b = readLine();var cnt = 0

        for(i in a.indices) {
            if(a[i] != b[i]) cnt++
        }

        sb.appendLine("Hamming distance is $cnt.")
    }

    print(sb)
}