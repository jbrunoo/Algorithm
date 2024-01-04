class Solution {
    fun solution(numbers: IntArray, n: Int): Int {
        var answer: Int = 0
        for(num in numbers) {
            answer += num
            if(answer > n) return answer
        }
        return answer
    }
}