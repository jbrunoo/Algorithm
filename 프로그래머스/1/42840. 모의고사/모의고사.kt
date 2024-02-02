class Solution {
    fun solution(answers: IntArray): IntArray {
        var winners = intArrayOf()
        val patterns = arrayOf(
            intArrayOf(1, 2, 3, 4, 5),
            intArrayOf(2, 1, 2, 3, 2, 4, 2, 5),
            intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5),  
        )
        val scores = IntArray(patterns.size)
        
        for((i, pattern) in patterns.withIndex()) {
            for((j, answer) in answers.withIndex()) {
                if(pattern[j % pattern.size] == answer) scores[i]++
            }
        }
        
        val maxScore = scores.maxOrNull()!!
        for((i, score) in scores.withIndex()) {
            if(score == maxScore) winners += i + 1
        }
        
        return winners
    }
}