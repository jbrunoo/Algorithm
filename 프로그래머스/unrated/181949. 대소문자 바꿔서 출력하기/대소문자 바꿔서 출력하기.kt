fun main(args: Array<String>) {
    val s1 = readln()
    var s2 = ""
    s1.forEach { c ->
        if(c.isLowerCase()) s2 += c.uppercase()
        else s2 +=c.lowercase()
    }
    println(s2)
}