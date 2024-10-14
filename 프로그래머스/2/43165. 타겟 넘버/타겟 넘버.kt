class Solution {
    private var answer = 0

    fun solution(numbers: IntArray, target: Int): Int {
        dfs(-1, 0, numbers, target)
        return answer
    }

    private fun dfs(cnt: Int, sum: Int, numbers: IntArray, target: Int) {
        if(cnt == numbers.size - 1) {
            if(sum == target) answer++
            return
        }

        dfs(cnt+1, sum + numbers[cnt+1], numbers, target)
        dfs(cnt+1, sum - numbers[cnt+1], numbers, target)
    }
}