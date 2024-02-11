class Solution {
    fun solution(s: String): String {
        var answer = ""
        val list = s.split(" ").map {
            it.mapIndexed { i, v ->
                if(i == 0) v.toUpperCase()
                else v.toLowerCase()
            }
        }
        answer = list.map { it.joinToString("") }.joinToString(" ")
        return answer
    }
}