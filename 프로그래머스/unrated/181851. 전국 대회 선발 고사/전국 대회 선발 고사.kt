class Solution {
    fun solution(rank: IntArray, attendance: BooleanArray): Int {
        var keyMap = mutableMapOf<Int, Int>()
        rank.mapIndexed { idx, value ->
            keyMap[value] = idx
        }
        val keys = keyMap.filter {
            attendance[it.value]
        }.keys.sorted()
        return 10000 * keyMap[keys[0]]!! + 100 * keyMap[keys[1]]!! + keyMap[keys[2]]!!
    }
}