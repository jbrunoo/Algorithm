class Solution {
    fun solution(s: String, n: Int): String {
        var answer = ""
        s.forEach {
            if(it == ' ') answer += " "
            else {
                val new = it + n
                if(it.isUpperCase()) {
                    if(new > 'Z') answer += (new - 26).toString()
                    else answer += new.toString()
                } else {
                    if(new > 'z') answer += (new - 26).toString()
                    else answer += new.toString()
                }
            }
        }
        
        return answer
    }
}