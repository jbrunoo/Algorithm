class Solution {
    fun solution(strArr: Array<String>): Int {
        return strArr.groupingBy { it.length }.eachCount().values.maxOrNull() ?: 0
    }
}