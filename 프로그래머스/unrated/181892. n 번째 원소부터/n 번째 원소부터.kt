class Solution {
    fun solution(num_list: IntArray, n: Int): IntArray {
        var answer: IntArray = intArrayOf()
        (n - 1 until num_list.size).forEach {
            answer += num_list[it]
        }
        return answer
    }
}