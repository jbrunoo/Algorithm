fun main(args: Array<String>) {
		val input = readLine()!!.split(' ')
    val s1 = input[0]
    val a = input[1]!!.toInt()
    var answer = ""
    for(i in 1..a) answer += s1
    println(answer)
}