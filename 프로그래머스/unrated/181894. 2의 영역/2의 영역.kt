class Solution {
    fun solution(arr: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        for(i in arr.indices) {
            if(arr[i] == 2) answer += i
        }
        if(answer.isEmpty()) answer += -1 
        else answer = arr.slice(answer.first()..answer.last()).toIntArray() 
        return answer
    }
}