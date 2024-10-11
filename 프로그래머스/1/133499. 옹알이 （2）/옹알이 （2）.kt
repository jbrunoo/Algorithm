class Solution {
    fun solution(babbling: Array<String>): Int {
        var answer: Int = 0
        val spk = listOf("aya", "ye", "woo", "ma")
        val noSpk = listOf("ayaaya", "yeye", "woowoo", "mama")

        for(b in babbling) {
            var flag = false
            var tmp = b
            
            for(ns in noSpk) {
                if(tmp.contains(ns)) {
                    flag = true
                    break
                }
            }
            if(flag) continue

            for(s in spk) {
                tmp = tmp.replace(s, "0")
            }
            if(tmp.replace("0", "").isEmpty()) answer++
        }


        return answer
    }
}