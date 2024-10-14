class Solution {
    private var answer = 0

    fun solution(numbers: IntArray, target: Int): Int {
        return dfs(-1, 0, numbers, target)
    }

    private fun dfs(cnt: Int, sum: Int, numbers: IntArray, target: Int): Int {
        if(cnt == numbers.size - 1) {
            return if(sum == target) 1 else 0
        }

        return dfs(cnt+1, sum + numbers[cnt+1], numbers, target) + dfs(cnt+1, sum - numbers[cnt+1], numbers, target)
    }
}