fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    var result = 0

    repeat(n) {
        val s = readLine()
        val stack = ArrayList<Char>()

        for(c in s) {
            if(stack.isEmpty()) stack.add(c)
            else if(stack.last() == c) stack.removeLast()
            else stack.add(c)
        }

        if(stack.isEmpty()) result++
    }

    println(result)

}