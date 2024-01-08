class Solution {
    fun solution(arr: IntArray, n: Int): IntArray {
        var answer: IntArray = arr
        if(answer.size % 2 == 0) {
            for(i in 1..answer.size - 1 step 2) answer[i] += n 
        } else {
            for(i in answer.indices step 2) answer[i] += n
        }
        return answer
    }
}