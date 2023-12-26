class Solution {
    fun solution(code: String): String {
        var answer: String = ""
        var mode: Int = 0
        
        for(idx in 0 until code.length) {
            if(mode == 0) {
                if(code[idx] != '1') {
                    if(idx % 2 == 0) answer += code[idx]
                }
                else mode = 1
            } else {
                if(code[idx] != '1') {
                    if(idx % 2 != 0) answer += code[idx]
                }
                else mode = 0
            }
        }
        
        if(answer.isEmpty()) answer = "EMPTY"
        
        return answer
    }
}