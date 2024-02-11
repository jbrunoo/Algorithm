class Solution {
    fun solution(s: String): String {
        var answer = ""
        val sList = s.split(" ")
        answer += sList.map {it.toInt()}.minOrNull()
        answer += " "
        answer += sList.map {it.toInt()}.maxOrNull()
        return answer
    }
}