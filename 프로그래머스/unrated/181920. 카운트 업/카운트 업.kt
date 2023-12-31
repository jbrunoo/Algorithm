class Solution {
    fun solution(start_num: Int, end_num: Int): IntArray {
        var answer: MutableList<Int> = mutableListOf()
        (start_num..end_num).forEach {
            answer.add(it)
        }
        return answer.toIntArray()
    }
}