class Solution {
    fun solution(my_strings: Array<String>, parts: Array<IntArray>): String {
        // return my_strings.indices.map { my_strings[it].slice(parts[it][0]..parts[it][1]) }.joinToString("")
        
        var answer = StringBuilder()
        for(i in parts.indices) {
            val (s, e) = parts[i]
            answer.append(my_strings[i].slice(s..e))
        }
        return answer.toString()
    }
}