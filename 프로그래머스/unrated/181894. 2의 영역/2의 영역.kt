class Solution {
    fun solution(arr: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        for(i in arr.indices) {
            if(arr[i] == 2) answer += i
        } // arr.contains(2)
        return if(answer.isEmpty()) intArrayOf(-1) else arr.slice(answer.first()..answer.last()).toIntArray()
    }
}