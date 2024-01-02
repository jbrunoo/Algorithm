class Solution {
    fun solution(my_string: String, indices: IntArray): String {
        var answer: String = my_string
        var cnt = 0
        for(idx in indices.sorted()) {
            answer = answer.removeRange((idx-cnt)..(idx-cnt))
            cnt++
        }
        return answer
    }
}