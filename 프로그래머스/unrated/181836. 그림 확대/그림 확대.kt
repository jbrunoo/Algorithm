class Solution {
    fun solution(picture: Array<String>, k: Int): Array<String> {
        var answer: Array<String> = arrayOf<String>()
        for(str in picture) {
              repeat(k) { answer += str.map { it.toString().repeat(k) }.joinToString("") }
        }
        return answer
    }
}