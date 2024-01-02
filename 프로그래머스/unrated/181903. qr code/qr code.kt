class Solution {
    fun solution(q: Int, r: Int, code: String): String {
        var answer = StringBuilder()
        for(i in code.indices) {
            if(i % q == r) answer.append(code[i])
        }
        return answer.toString()
    }
}