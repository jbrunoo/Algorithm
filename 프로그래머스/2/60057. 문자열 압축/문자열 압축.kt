class Solution {
    fun solution(s: String): Int {
        var wordList = mutableListOf<String>()

        for(i in 1..s.length / 2 + 1) {
            var word = ""
            val subList = s.chunked(i)
            var sum = 0
            var idx = 0
            subList.forEachIndexed { j, v ->
                if(subList[idx] == v) {
                    sum++
                } else {
                    if(sum !in 0..1) word += sum.toString() + subList[j-1]
                    else word += subList[j-1]
                    idx = j
                    sum = 1
                }
                if(j == subList.lastIndex) {
                    if(sum !in 0..1) word += sum.toString() + v
                    else word += v
                }
            }
            wordList.add(word)
        }

        return wordList.map { it.length }.minOrNull()!!
    }
}