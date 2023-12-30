class Solution {
    fun solution(num_list: IntArray): IntArray {
        var answer: MutableList<Int> = mutableListOf()
        val first = num_list[num_list.size - 2]
        val second = num_list[num_list.size - 1]
        
        for(num in num_list) {
            answer.add(num)
        }
        
        if(first < second) answer.add(second - first) else answer.add(second * 2)
        return answer.toIntArray()
    }
}