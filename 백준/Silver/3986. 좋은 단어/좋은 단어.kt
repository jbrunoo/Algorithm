fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    var result = 0

    repeat(n) {
        val s = readLine()
        val stack = ArrayList<Char>()

        for(c in s) {
            if(stack.isEmpty()) stack.add(0, c)
            else if(stack.first() == c) stack.removeFirst()
            else stack.add(0, c)
        }

        if(stack.isEmpty()) result++
    }

    println(result)

}