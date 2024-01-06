class Solution {
    fun solution(myString: String, pat: String): Int {
        var answer: Int = 0
        val endPoint = myString.length - pat.length
        for(i in 0..endPoint) {
            if(myString.substring(i until i + pat.length) == pat) answer++
        }
        return answer
    }
}