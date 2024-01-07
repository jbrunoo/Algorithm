class Solution {
    fun solution(myStr: String): Array<String> {
        var answer: Array<String> = arrayOf<String>()
        // var s = StringBuilder(myStr)
        var s = myStr
        s = s.replace(Regex("a|b|c"), " ") // .toRegex()
        // s = s.replace("b", " ")
        // s = s.replace("c", " ")
        answer = s.trim().split(" ").filter { it.length > 0 }.toTypedArray() // it.length > 0 -> it.isNotEmpty() || isNotBlank()
        // .let {if(it.isEmpty) arrayOf("EMPTY")} 한 줄
        return if(answer.isEmpty()) arrayOf("EMPTY") else answer
    }
}