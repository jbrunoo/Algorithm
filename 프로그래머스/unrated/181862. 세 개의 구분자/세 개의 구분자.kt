class Solution {
    fun solution(myStr: String): Array<String> {
        var answer: Array<String> = arrayOf<String>()
        // var s = StringBuilder(myStr)
        var s = myStr
        s = s.replace("a", " ")
        s = s.replace("b", " ")
        s = s.replace("c", " ")
        answer = s.trim().split(" ").filter { it.length > 0 }.toTypedArray()
        return if(answer.isEmpty()) arrayOf("EMPTY") else answer
    }
}