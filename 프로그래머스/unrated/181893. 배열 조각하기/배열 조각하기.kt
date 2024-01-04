class Solution {
    fun solution(arr: IntArray, query: IntArray): IntArray {
        var answer: MutableList<Int> = arr.toMutableList()
        for(i in query.indices) {
            if(i % 2 == 0) {
                answer = answer.slice(0..query[i]).toMutableList()
            } else {
                answer = answer.slice(query[i]..answer.size - 1).toMutableList()
            }
        }
        return answer.toIntArray()
    }
}