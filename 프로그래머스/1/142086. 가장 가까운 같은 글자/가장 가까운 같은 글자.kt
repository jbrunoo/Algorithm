class Solution {
    fun solution(s: String): IntArray {
        var answer: IntArray = intArrayOf()
        var map = mutableMapOf<Char, Int>()
        
        s.forEachIndexed { idx, v ->
            if(v !in map.keys) {
                map[v] = idx
                answer += -1
            } else {
                answer += idx - map[v]!!
                map[v] = idx
            }
        }
        
        return answer
    }
}