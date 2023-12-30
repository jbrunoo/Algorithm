class Solution {
    fun solution(num_list: IntArray): IntArray {
        var answer: MutableList<Int> = mutableListOf()
        val size = num_list.size
        for(i in num_list) {
            answer.add(i)
        }
        if(num_list[size - 2] < num_list[size - 1]) answer.add(num_list[size - 1] - num_list[size - 2]) else answer.add(num_list[size - 1] * 2)
        return answer.toIntArray()
    }
}