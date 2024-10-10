fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i():Int{nextToken();return nval.toInt()};val sb=StringBuilder()
    repeat(i()) {
        var same = 0
        val li = IntArray(i()) { i() }.sorted().toIntArray()

        for(a in 0 until li.size) {
            for(b in a + 1 until li.size) {
                val dist = li[b] - li[a]
                if(dist % 2 == 0 && li.binarySearch(li[a] + dist / 2) >= 0) same++
            }
        }

        sb.appendLine(same)
    }
    print(sb)
}