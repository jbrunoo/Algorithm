class Solution {
    fun solution(s: String): Int {
        var answerList = mutableListOf<String>()
        
        for(i in 1..s.length / 2 + 1) {
            var answer = ""
            val splitStr = s.chunked(i)
            var sum = 0
            var idx = 0
            splitStr.forEachIndexed { j, v ->
                if(splitStr[idx] == v) {
                    sum++
                } else {
                    if(sum !in 0..1) answer += sum.toString() + splitStr[j-1]
                    else answer += splitStr[j-1]
                    idx = j
                    sum = 1
                }
                if(j == splitStr.lastIndex) {
                    if(sum !in 0..1) answer += sum.toString() + v
                    else answer += v
                }
            }
            answerList.add(answer)
        }
        
        return answerList.map { it.length }.minOrNull()!!
    }
}