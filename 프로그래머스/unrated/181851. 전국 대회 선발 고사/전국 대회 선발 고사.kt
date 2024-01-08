class Solution {
    fun solution(rank: IntArray, attendance: BooleanArray): Int {
        // var keyMap = mutableMapOf<Int, Int>()
        // rank.mapIndexed { idx, value ->
        //     keyMap[value] = idx
        // }
        // val keys = keyMap.filter {
        //     attendance[it.value]
        // }.keys.sorted()
        // return 10000 * keyMap[keys[0]]!! + 100 * keyMap[keys[1]]!! + keyMap[keys[2]]!!
        
        // pair 활용
        val answer = rank.mapIndexed { i, v -> v to i }.filter { attendance[it.second] }.sortedBy { it.first }
        return 10000 * answer[0].second + 100 * answer[1].second + answer[2].second
        
    }
}