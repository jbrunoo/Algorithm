class Solution {
    fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {
        var answer: IntArray = intArrayOf()
        var nameMap: MutableMap<String, Int> = mutableMapOf()
        for(i in name.indices) {
            nameMap[name[i]] = yearning[i]
        }
        
        for(names in photo) {
            var point = 0
            for(name in names) {
                point += nameMap[name] ?: 0
            }
            answer += point
        }
        return answer
    }
}